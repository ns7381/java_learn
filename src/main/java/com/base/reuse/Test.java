package com.base.reuse;

/**
 * Created by nathan on 16/8/2.
 */
public class Test {
    public static void main(String[] args) {
        BookFacadeJDKProxy proxy = new BookFacadeJDKProxy();
        BookFacade bookFacadeImplProxy = (BookFacade)proxy.bind(new BookFacadeImpl());
        bookFacadeImplProxy.addBook();
        BookFacadeCGLIBProxy bookFacadeCGLIBProxy = new BookFacadeCGLIBProxy();
        BookFacadeImpl2 instance = (BookFacadeImpl2) bookFacadeCGLIBProxy.getInstance(new BookFacadeImpl2());
        instance.addBook();
    }
}
