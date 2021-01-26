package com.nathan.learn.base.enumerated;

import java.util.Iterator;

/**
 * Created by nathan on 17/1/16.
 */
class Mail {
    enum GeneralDelivery {
        YES, NO1, NO2
    }

    enum Scannability {
        UNSCANNABLE, YES1, YES2
    }

    GeneralDelivery generalDelivery;
    Scannability scannability;
    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail "+id;
    }

    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY{
            boolean handle(Mail mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        System.out.println("use general delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            boolean handle(Mail mail) {
                switch (mail.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        System.out.println("delivering " + mail + " automatically");
                        return true;
                }

            }
        };

        abstract boolean handle(Mail mail);
    }

    static void handle(Mail mail) {
        for (MailHandler mailHandler : MailHandler.values()) {
            if (mailHandler.handle(mail)) {
                return;
            }
        }
        System.out.println(mail + " is a dead letter");
    }
    public static void main(String[] args) {
        for (Mail mail : Mail.generator(2)) {
            handle(mail);
            System.out.println("***************");
        }
    }
}
