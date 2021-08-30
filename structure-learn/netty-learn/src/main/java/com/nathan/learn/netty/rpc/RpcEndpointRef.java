package com.nathan.learn.netty.rpc;

public class RpcEndpointRef {

    /**
     * return the address for the [[RpcEndpointRef]]
     */
    def address: RpcAddress

    def name: String

    /**
     * Sends a one-way asynchronous message. Fire-and-forget semantics.
     */
    def send(message: Any): Unit

    /**
     * Send a message to the corresponding [[RpcEndpoint.receiveAndReply)]] and return a
     * [[AbortableRpcFuture]] to receive the reply within the specified timeout.
     * The [[AbortableRpcFuture]] instance wraps [[Future]] with additional `abort` method.
     *
     * This method only sends the message once and never retries.
     */
    def askAbortable[T: ClassTag](message: Any, timeout: RpcTimeout): AbortableRpcFuture[T] = {
        throw new UnsupportedOperationException()
    }

    /**
     * Send a message to the corresponding [[RpcEndpoint.receiveAndReply)]] and return a [[Future]] to
     * receive the reply within the specified timeout.
     *
     * This method only sends the message once and never retries.
     */
    def ask[T: ClassTag](message: Any, timeout: RpcTimeout): Future[T]

    /**
     * Send a message to the corresponding [[RpcEndpoint.receiveAndReply)]] and return a [[Future]] to
     * receive the reply within a default timeout.
     *
     * This method only sends the message once and never retries.
     */
    def ask[T: ClassTag](message: Any): Future[T] = ask(message, defaultAskTimeout)

    /**
     * Send a message to the corresponding [[RpcEndpoint.receiveAndReply]] and get its result within a
     * default timeout, throw an exception if this fails.
     *
     * Note: this is a blocking action which may cost a lot of time,  so don't call it in a message
     * loop of [[RpcEndpoint]].

     * @param message the message to send
     * @tparam T type of the reply message
     * @return the reply message from the corresponding [[RpcEndpoint]]
     */
    def askSync[T: ClassTag](message: Any): T = askSync(message, defaultAskTimeout)

    /**
     * Send a message to the corresponding [[RpcEndpoint.receiveAndReply]] and get its result within a
     * specified timeout, throw an exception if this fails.
     *
     * Note: this is a blocking action which may cost a lot of time, so don't call it in a message
     * loop of [[RpcEndpoint]].
     *
     * @param message the message to send
     * @param timeout the timeout duration
     * @tparam T type of the reply message
     * @return the reply message from the corresponding [[RpcEndpoint]]
     */
    def askSync[T: ClassTag](message: Any, timeout: RpcTimeout): T = {
        val future = ask[T](message, timeout)
        timeout.awaitResult(future)
    }
}
