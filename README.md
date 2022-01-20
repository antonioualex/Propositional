# Propositional Logic

Implementation of two **reasoning** methods with **Horn** clauses and **Resolution**.

### Reasoning with Resolution:

The program is reading clauses from the knowledge base file to check the rightness of resolution and accomplishes that by checking the opposite clause from clauseRef file is correct.
Format of the aforementioned files:
  - NOT character is presented as "-"
  - AND character is presented as the change line “\n”
  - OR character is presented as space " "

o CNFClause.java : περιέχει Arraylist με τα subclauses που υπάρχουν σε μια
πρόταση σε μορφή CNF και συνδέονται με AND.
o Literal.java : περιέχει το όνομα ενός Literal μιας πρότασης, ελέγχοντας αν
βρίσκεται σε άρνηση ή οχι.
o MainResolution.java : τρέχει τον αλγόριθμο της ανάλυσης (resolution) για τα
δοθούντα αρχεία (βαση γνώσης και την άρνηση της πρότασης) μέσω της
μεθόδου PL_Resolution. Τέλος, εμφανίζει αν η άρνηση της πρότασης είναι
αληθής ή ψευδής.
o SubClause.java : Περιέχει HashSet με Literals που έχει το κάθε subclause μιας
πρότασης σε CNF.
o CNFUtils.java : (κοινή κλάση με το Horn) που διαβάζουμε τα δοθούντα
αρχεία.

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
