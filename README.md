# Propositional Logic

Implementation of two **reasoning** models with **Horn** clauses and **Resolution**.

### Reasoning with Resolution:

The program is reading clauses from a knowledge base to check whether the resolution is right. This is accomplished by comparing a clause with its opposite. <br><br>
Dictionary format :
  - NOT operator is presented as "-"
  - AND operator is presented as the change line “\n”
  - OR operator is presented as space " "
 #### *Program structure* (classes) <br>
- **CNFClause** : Arraylist of CNF subclauses (with the same parent) linked to the "AND" operator. <br>
- **Literal** : Contains the Literal of a clause, checking if it is negative or not.<br>
- **MainResolution** : Performs the resolution algorithm for the provided files (knowledge base and the negative clause) via PL_Analysis method. Finally, it shows whether the negative clause is true or false.<br>
- **SubClause** : Contains HashSet Literals for each sub-clause of a CNF clause.<br>
- **CNFUtils** : Reads data from the given files. (Common class for both propositional models)<br>

### Forward chaining reasoning with Horn clauses:
A Knowledge Base which is formatted as seen below:

>Each line corresponds to a Horn clause ("\n").
 - AND operator is presented as " "
 - "=>" (conclusion) operator is presented as “=>”
#### *Program structure* (classes)<br>
 - **ClauseHorn**: Arraylist of Horn clauses symbols.<br>
 - **KB**( KnowledgeBase): Storage of Horn clauses into two ArrayLists.
 Here we store the suggestions of our knowledge base. Inside the first
 ArrayList we store the symbols that were only in the knowledge base (**facts**)
  and inside the second Horn clause ArrayList we have the clauses that are excluded from the facts.<br> 
 - **MainHorn** : Saves the current knowledge base and the set of symbols
the user gives as input to check what is valid (or q! to exit). After
executes the forward chaining reasoning for horn clauses algorithm via the HornAlgorithm method, where true is returned
or false, depending on whether the symbol is located or not.<br>
- **CNFUtils** : Reads data from the given files (Common class for both propositional models).<br><br>

> Contains the necessary text files for the knowledge base and the clause
we want, which are also used as examples.
