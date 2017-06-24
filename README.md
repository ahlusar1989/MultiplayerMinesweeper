**Multithreading**

Uses immutable or thread-safe data structures
Uses a queue to send messages that will be processed sequentially by a single thread


**Message Protocol**

Messages in this protocol are described precisely and comprehensively using a pair of grammars. 
The server accepts any incoming message that satisfies the user-to-server grammar, react appropriately, 
and generate only outgoing messages that satisfy the server-to-user grammar - in this case
the Backus–Naur Form.

**Client**

Telnet

**Note**

Most of the Abstract Date Types in this client/server program don’t need to rely on networking. 
I made sure to specify, test, and implement them as separate components that are safe from bugs, 
easy to understand, and ready for change — in part because they don’t involve any networking code.

The Invariant for the server is guaranteed through the thread safety strategies of confinement, 
immutability, and existing threadsafe data types .