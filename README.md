# Propositional Logic

Implementation of two **reasoning** methods with **Horn** clauses and **Resolution**.

### Reasoning with Resolution:

The program is reading clauses from the knowledge base file to check the rightness of resolution and accomplishes that by checking the opposite clause from clauseRef file is correct.
Format of the aforementioned files:
  - NOT character is presented as "-"
  - AND character is presented as the change line “\n”
  - OR character is presented as space " "
> #### Files Included<br/>
> - **CNFClause** : Arraylist of CNF subclauses (which are clauses) related to the "AND" operator. <br/>
> - **Literal** : Contains the Literal name of a clause, checking if it is negative or not.<br/>
> - **MainResolution** : Performs the resolution algorithm for provided files (knowledge base and the negative clause) via PL_Analysis &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;method. Finally, it shows whether the negative clause is true or false.<br/>
> - **SubClause** : Contains Literals HashSet for each sub-clause of a CNF clause.<br/>
> - **CNFUtils** : Reads data from the given files. (Common class for both propositional models)<br/>

### Forward chaining Reasoning with Horn clauses:
Ένα αρχείο KnowledgeBaseHorn.txt που περιέχει τη βάση γνώσης με την παρακάτω
μορφή :
Κάθε πρόταση Horn συμβολίζεται με αλλαγή γραμμής “\n”
Για AND έχουμε τον χαρακτήρα “ ”
Για => τους χαρακτήρες “=>”
Στο Horn έχουμε τις εξής κλάσεις :
o ClauseHorn.java : Περιέχει ArrayList με Strings, τα οποία αντιπροσωπεύουν
τα σύμβολα της πρότασης Horn.
o KB.java : Εδώ αποθηκεύουμε τις προτασεις της βάσης γνώσης μας. Στο ένα
ArrayList έχουμε τα σύμβολα που ήταν μόνα τους στη βάση γνώσης (facts)
και στο ArrayList με τα HornClause έχουμε τα clauses απο τις προτάσεις Horn
εκτός των facts.
o MainHorn.java : Αποθηκεύει τη δοθούσα βάση γνώσης και το σύμβολο που
ο χρήστης πληκτρολογεί για να ελέγξει τι ισχύει (ή q! για έξοδο). Έπειτα
τρέχει τον αλγόριθμο εξαγωγής συμπερασμάτων προς τα εμπρός για
προτάσεις Horn μέσω της μεθόδου HornAlgorithm, όπου επιστρέφεται true
ή false, αναλόγως αν βρεθεί το σύμβολο ή οχι.
o CNFUtils.java : (κοινή κλάση με το Resolution) που διαβάζουμε τα δοθούντα
αρχεία.
*Περιέχονται τα απαραίτητα αρχεία text για τη βάση γνώσης και την πρόταση που
θέλουμε, τα οποία χρησιμοποιούνται και ως παραδείγματα.
