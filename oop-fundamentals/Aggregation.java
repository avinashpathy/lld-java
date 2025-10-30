/*
A special form of association where one class contains another class as a part,
but the contained object can exist independently.

It represents a weak relationship. 

Key Characteristics of Aggregation:
    The whole and the part are logically connected.
    The part can exist independently of the whole.
    The whole does not own the part.
    The part can be shared among multiple wholes.
    Both the whole and the part can be created and destroyed independently.

Example - Department has professors. Professors are part of a department but both can exist independently.
*/
import java.util.*;

class Aggregation {
    public static void main(String[] args){
        Professor p1 = new Professor("Dr. Smith");
        Professor p2 = new Professor("Dr. Johnson");

        List<Professor>profs = List.of(p1,p2);
        Department csDept = new Department("Computer Science", profs);
        csDept.printProfessors();
    }
}