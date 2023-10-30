1. Created constructor for User class and
overloaded it:
one with default input, another allowing User's input.
2. Handled Illegal Argument exception for age attribute creating the method
which asserts whether the age is negative or higher than 150. 

**What could go wrong if we didn’t do this type of handling?**

_In case of a negative number, it would created a mess for our data analysis (summary statistics);
our database can crash during API (it accepts just positives) (my husband's answer, not gpt);_

3. For displaying user's information, overrided toString method.

**Where else could we display this? How?**

_For example, in the database through API._

4. _Question:_ We were recommended to user StringBuilder as a good practice
but to write string to the file we need to convert it. So what would be 
a good practice in that case?

**What if the file is corrupted?
What if the file is readable but not properly formatted?
How can we prevent this?**

If the file has been corrupted, the user information can be lost, and the 
file is impossible(?) to restore. It shows an error during restoring.

If the file has not been properly formatted, there are difficulties with reading it
and parsing it.

To prevent it, we should implement a proper error handling. 

**How do we structure the data about books?**

It's better to keep them in Arraylist. In some cases when we have just author and title,
or User + title, map would work the best.










