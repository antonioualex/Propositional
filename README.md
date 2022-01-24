# Propositional Logic

Implementation of two **reasoning** methods with **Horn** clauses and **Resolution**.

### Reasoning with Resolution:

The program is reading clauses from the knowledge base to check the resolution rightness and accomplishes that, by checking the opposite clause from clauseRef file is correct.<br>
Format of the aforementioned files :
  - NOT operator is presented as "-"
  - AND operator is presented as the change line “\n”
  - OR operator is presented as space " "
 #### *Files Included*<br>
- **CNFClause** : Arraylist of CNF subclauses (which are clauses) related to the "AND" operator. <br>
- **Literal** : Contains the Literal name of a clause, checking if it is negative or not.<br>
- **MainResolution** : Performs the resolution algorithm for provided files (knowledge base and the negative clause) via PL_Analysis method. Finally, it shows whether the negative clause is true or false.<br>
- **SubClause** : Contains Literals HashSet for each sub-clause of a CNF clause.<br>
- **CNFUtils** : Reads data from the given files. (Common class for both propositional models)<br>

### Forward chaining Reasoning with Horn clauses:
A Knowledge Base which is formated as seen below:

>Each line corresponds to a Horn clause ("\n").
 - AND operator is presented as " "
 - "=>" (conclusion) operator is presented as “=>”
#### *Files Included*<br>
 - **ClauseHorn**: Arraylist of Horn clauses symbols.<br>
 - **KB**( KnowledgeBase): Storage of Horn clauses into two ArrayLists.
 Here we store the suggestions of our knowledge base. Inside first
 ArrayList we store the symbols that were only in the knowledge base (**facts**)
  and inside the second Horn clause ArrayList we have the clauses that are excluded from the facts.<br> 
 - **MainHorn** : Saves the current knowledge base and the set of symbols
the user gives as input to check what is valid (or q! to exit). After
executes the forward chaining reasoning for horn clauses algorithm via the HornAlgorithm method, where true is returned
or false, depending on whether the symbol is located or not.<br>
- **CNFUtils** : Reads data from the given files (Common class for both propositional models).<br><br>

> Contains the necessary text files for the knowledge base and the clause
we want, which are also used as examples.
