Socket Chat APP
===============
This is very simnple socket chatting application utilizing TCP/IP & multi-threads.

### TCP/IP based
I use TCP/IP due to its reliability. UDP does NOT gurantee the message received.

### Multi-thread based
Either Server or Client use the same begininng process/interface.
Therefore, another thread is forked to handle messages sent/received.
