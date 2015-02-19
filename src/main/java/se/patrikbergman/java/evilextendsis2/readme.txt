Example of how extension/inherited functionality can be fragile for change

"Note you don't have this problem if you use interface inheritance, since there's no inherited functionality to go
bad on you. If Stack is an interface, implemented by both a Simple_stack and a Monitorable_stack, then the code is
much more robust"
http://www.javaworld.com/article/2073649/core-java/why-extends-is-evil.html