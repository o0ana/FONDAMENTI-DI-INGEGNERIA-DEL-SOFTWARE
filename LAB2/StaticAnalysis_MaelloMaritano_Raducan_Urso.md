<style>
	/* Global Styles */
body {
    font-family: Arial, sans-serif;
    line-height: 1.6;
    margin: 20px;
    background-color: #f4f4f4;
    color: #333;
}

h1, h2, h3 {
    color: #333;
    font-weight: bold;
}

h1 {
    font-size: 26px;
    border-bottom: 2px solid #000;
    padding-bottom: 10px;
}

h2 {
    font-size: 22px;
    margin-top: 20px;
}

h3 {
    font-size: 20px;
    margin-top: 15px;
}

/* Table Styles */
table {
    width: 100%;
    margin-top: 20px;
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid #ddd;
    text-align: left;
}

th {
    background-color: #f2f2f2;
    padding: 8px;
}

td {
    padding: 8px;
}

code {
    font-family: "Courier New", Courier, monospace;
    background-color: #f5f5f5;
    padding: 5px;
    border-radius: 5px;
}

pre code {
    font-size: 14px;
    display: block;
    white-space: pre-wrap;
    word-wrap: break-word;
}

/* Divider */

hr {
    border: 0;
    border-top: 1px solid #ccc;
    margin: 20px auto;
}
</style>


Maello Maritano Marianna (6442338), Raducan Ana Maria (5797859), Urso Federico (5869954)

# Static Analysis

## SonarQube

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| User | 15 | S2293 | The diamond operation ("<>") should be used | Maintainability |
```java
private List<String> titles = new ArrayList<String>();
```
Correzione:
```java
private List<String> titles = new ArrayList<>();
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| User | 68 | S1126 | Return of boolean expression should not be wrapped into an "if-then-else" statement | Maintainability |
```java
if(accountActive)
	return true;
return false;
```
Correzione:
```java
return this.isAccountActive();
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| User | 74 | S4973 | Strings and Boxed types should be compared using "equals()" | Reliability |
```java
if (accountActive && this.userID == id)
```
Correzione:
```java
if (accountActive && this.userID.equals(id))
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| User | 82 | S4973 | Strings and Boxed types should be compared using "equals()" | Reliability |
```java
return u.userID == this.userID;
```
Correzione:
```java
return u.userID.equals(this.userID);
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| User | 86 | S106 | Standard outputs should not be used directly to log anything | Maintainability |
| User | 86 | S2629 | "Preconditions" and logging arguments should not require evaluation | Maintainability |
```java
System.out.println("User Info: " + firstname + " " + lastname + " (Username: " + username + ")");
```
Correzione:
```java
import java.util.logging.Logger;
//...
private static final Logger logger = Logger.getLogger(User.class.getName());
//...
if(logger.isLoggable(Level.INFO)) {
	logger.info("User Info: " + firstname + " " + lastname + " (Username: " + username + ")");
}
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| User | 89 | S112 | Generic exceptions should never be thrown | Maintainability |
```java
public void linkCart(Cart cart) throws Exception{
	if(cart == null)
		throw new Exception();
	this.cart = cart;
}
```
Correzione:
```java
public void linkCart(Cart cart) throws NullPointerException{
	if(cart == null)
		throw new NullPointerException();
	this.cart = cart;
}
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| User | 100 | S2116 | "hashCode" and "toString" should not be called on array instances | Reliability |
```java
return roles.toString();
```
Correzione:
```java
import java.util.Arrays;
// ...
return Arrays.toString(roles);
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| User | 103 | S100 | Method names should comply with a naming convention | Maintainability |
```java
public void PrintEveryRole()
```
Correzione:
```java
public void printEveryRole()
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| User | 104 | S2189 | Loops should not be infinite | Reliability |
| User | 104 | S2251 | A "for" loop update clause should move the counter in the right direction | Reliability |
```java
for (int i = roles.length; i>0; i++)
```
Correzione:
```java
for (int i = roles.length-1; i>0; i--)
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| User | 105 | S106 | Standard outputs should not be used directly to log anything | Maintainability |
```java
System.out.println(roles[i]);
```
Correzione:
```java
logger.info(roles[i]);
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| UsersManager | 17 | S1124 | Modifiers should be declared in the correct order | Maintainability |
| UsersManager | 17 | s115 | Constant names should comply with a naming convention | Maintainability |
```java
public final static String basicUserID = "User00-";
```
Correzione:
```java
public static final String BASIC_USER_ID = "User00-";
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| UsersManager | 18 | S1124 | Modifiers should be declared in the correct order | Maintainability |
| UsersManager | 18 | s2386 | Mutable fields should not be "public static" | Maintainability |
| UsersManager | 18 | s2293 | The diamond operator ("<>") should be used | Maintainability |
```java
public final static List<User> users = new ArrayList<User>();
```
Correzione:
```java
protected static final List<User> users = new ArrayList<>();
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| UsersManager | 22 | S6437 | Credentials should not be hard-coded | Security |
```java
try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", BASIC_USER_ID+userID, "password");)
```
Correzione:
```java
try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", BASIC_USER_ID+userID, System.getenv("DB_PASSWORD"));)
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| UsersManager | 24 | S2095 | Resources should be closed | Reliability |
```java
try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", BASIC_USER_ID+userID, "password");) {
	String query = "select firstname, lastname " + "from USERS where username="+ (BASIC_USER_ID+userID);
	PreparedStatement stmt = conn.prepareStatement(query);
	ResultSet rs = stmt.executeQuery();
	//...
}
```
Correzione:
```java
String query = "select firstname, lastname " + "from USERS where username="+ (BASIC_USER_ID+userID);
try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", BASIC_USER_ID+userID, System.getenv("DB_PASSWORD"));
	PreparedStatement stmt = conn.prepareStatement(query);
	ResultSet rs = stmt.executeQuery();)
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| UsersManager | 27 | S2589 | Boolean expressions should not be gratuitous | Maintainability |
```java
while (rs.next())
	if(rs != null)
		return true;
return false;
```
Correzione:
```java
return (rs.next());
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| UsersManager | 45 | S5413 | 'List.remove()' should not be used in ascending 'for' loops | Maintainability |
```java
for (int i = 0; i < titles.size(); i++) {
	if (titles.get(i).isEmpty()) {
	titles.remove(i);
	}
}
```
Correzione:
```java
titles.removeIf(String::isEmpty);
```

---

| Classe | Linea | Codice errore | Messaggio errore | Tipo errore |
| --- | --- | --- | --- | --- |
| UsersManager | 54 | S2737 | "catch" clauses should do more than rethrow | Maintainability |
| UsersManager | 54 | S112 | Generic exceptions should never be thrown | Maintainability |
```java
void addCartToUser(User user, Cart cart) throws Exception {
	try {
		user.linkCart(cart);
	} catch (Exception e) {
		throw e;
	}
}
```
Correzione:
```java
void addCartToUser(User user, Cart cart) throws NullPointerException {
	user.linkCart(cart);
}
```

### Hints

| Classe | Linea | Messaggio errore |
| --- | --- | --- |
| User | 11 | Field can be final |
```java
private String userID;
private String firstname;
private String lastname;
```
Correzione:
```java
private final String userID;
private final String firstname;
private final String lastname;
```

---

| Classe | Linea | Messaggio errore |
| --- | --- | --- |
| User | 86 | Inefficient use of string concatenation in logger |
```java
logger.info("User Info: " + firstname + " " + lastname + " (Username: " + username + ")");
```
Correzione:
```java
logger.info(String.format("User Info: %s %s (Username: %s)", firstname, lastname, username));
```

---

| Classe | Linea | Messaggio errore |
| --- | --- | --- |
| UsersManagement | 36 | Method is never used |
```java
void addUser(User user) throws SQLException
//...
void removeEmptyTitlesFromUser(User user)
//...
void addCartToUser(User user, Cart cart) throws Exception
```
Correzione:
```java
public void addUser(User user) throws SQLException
//...
public void removeEmptyTitlesFromUser(User user)
//...
public void addCartToUser(User user, Cart cart) throws NullPointerException
```


## DesigniteJava

1. *Identificare i metodi con Complessità ciclomatica più alta nell’intero progetto “assignment”*

Da `MethodMetrics.csv`:  
I metodi sono `Cart.updateProductQuality` e `UsersManager.removeEmptyTitlesFromUser`, entrambi con complessità ciclomatica uguale a 3.

---

2. *Elencare e spiegare i code smell presenti nelle classi User e UserManager*

Da `ImplementationSmells.csv`:  
| Classe | Metodo | Smell |  | Descrizione |
| --- | --- | --- | --- | --- |
| User | User | Long Parameter List | Il metodo ha 7 parametri. | Se il costruttore di una classe ha tanti parametri, questa potrebbe star violando il principio di responsabilità singola (SRP). La classe `User` tratta diversi aspetti relativi agli utenti, che potrebbero essere invece gestiti in varie classi, ciascuna trattante funzioni più specifiche. Inoltre, l'elevata quantità di argomenti rende il codice meno leggibile, si potrebbero introdurre valori di default per i campi della classe e metodi set per alleggerire il metodo. |
| UsersManager | findUserFromDB | Long Statement | La lunghezza dello statement `try(Connection conn=[...])` è 229. | Statement troppo lunghi complicano leggibilità e manutenzione del codice. In questo caso si potrebbero dividere in più fasi le operazioni svolte sul DB, o evitare di usare un try-with-resources |

---

3. *La classe UserManager viola qualche principio di buon design? Se si spiegare perché*

Da `DesignSmells.csv`:  
| Smell | Principio violato | Spiegazione |
| --- | --- | --- |
| Unutilized Abstraction | Semplicità | La classe è inutilizzata. Normalmente un problema, in questo caso si può ignorare perché le classi non sono parte di un sistema funzionante, ma solo prese fuori contesto a scopo didattico |
| Deficient Encapsulation | Astrazione | I campi BASIC_USER_ID e users hanno visibilità pubblica. Sarebbe meglio se i campi fossero privati e accessibili con appositi metodi |

---

4. *Esistono problemi a livello di Architettura software di questo progetto? Se si spiegare quali*

Da `ArchitectureSmells.csv`:  
Il tool non ha rilevato alcun problema.

## Class Visualizer

### Cart

![Cart Diagram](ClassVisualizer/Cart%20relations%20diagram.png)

![Cart Properties](ClassVisualizer/Cart%20preview.png)  

| Uses |  | Used By |  |
| --- | --- | --- | --- |
| 3 | Integer, Map, Product | 2 | User, UsersManager |

---

### Product

![Product Diagram](ClassVisualizer/Product%20relations%20diagram.png)

![Product Properties](ClassVisualizer/Product%20preview.png)

| Uses |  | Used By |  |
| --- | --- | --- | --- |
| 1 | String | 1 | Cart |

---

### User

![User Diagram](ClassVisualizer/User%20relations%20diagram.png)

![User Properties](ClassVisualizer/User%20preview.png)

| Uses |  | Used By |  |
| --- | --- | --- | --- |
| 4 | Cart, List, Logger, String | 1 | UsersManager |

---

### UsersManager

![UsersManager Diagram](ClassVisualizer/UsersManager%20relations%20diagram.png)

![UsersManager Properties](ClassVisualizer/UsersManager%20preview.png)

| Uses |  | Used By |  |
| --- | --- | --- | --- |
| 4 | List, String, User, Cart | 0 | |