/*
Composition is a special type of association that signifies strong ownership between objects. The “whole” class is fully responsible for creating, managing, and destroying the “part” objects. In fact, the parts cannot exist without the whole.

Key Characteristics of Composition:
    Represents a strong “has-a” relationship.
    The whole owns the part and controls its lifecycle.
    When the whole is destroyed, the parts are also destroyed.
    The parts are not shared with any other object.
    The part has no independent meaning or identity outside the whole.
    If the part makes no sense without the whole, use composition.
*/

