https://algomaster.io/learn/lld/composition \
Association is a general connection: two classes simply know about each other.\
Aggregation is a grouping: the whole and parts can exist independently.\
Composition is an ownership: the part’s existence is bound to the whole.


Concept	Tip to Remember
SRP	One class = one reason to change
OCP	Add new code, don’t touch old code
LSP	Subclasses should behave like parents
ISP	Don’t force a class to implement unused methods
DIP	Depend on interfaces, not concrete classes