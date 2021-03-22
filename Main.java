
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

//Serializable Classes//

class BookData			// Our serializable class to store book data.
{
  String id, bookName, dueDate;
    BookData (String a, String b, String c)
  {
    id = a;
    bookName = b;
    dueDate = c;
  }

  public String toString ()
  {
    return id + ";" + bookName + ";" + dueDate;
  }
}

class StudentData		// Our serializable class to store student data.
{
  String uID, book1, book2, book3, book4, book5;
    StudentData (String uID, String book1, String book2, String book3,
		 String book4, String book5)
  {
    this.uID = uID;
    this.book1 = book1;
    this.book2 = book2;
    this.book3 = book3;
    this.book4 = book4;
    this.book5 = book5;
  }
  public String toString ()
  {
    return uID + ";" + book1 + ";" + book2 + ";" + book3 + ";" + book4 + ";" +
      book5;
  }

}



//Serializable Classes//



//Base File Reader.
class FileReader
{
  static String Read (String path)
  {
    String a = "";
      try
    {
      File file = new File (path);
      Scanner sc = new Scanner (file);

      // we just need to use \\Z as delimiter 
        sc.useDelimiter ("\\Z");
        a = sc.next ();

    }
    catch (Exception e)
    {

    }
    return a;

  }




}

class Writer
{
  static void WriteStudents (String FileName, StudentData[]s) throws Exception
  {
    /// for each st in s
    //NIKET
    // WriteLine st.toString();
    for (StudentData S:s)
      {
	WriteLine (S.toString (), FileName);
      }
  }
  static void WriteBooks (String FileName, BookData[]s) throws Exception
  {
    /// for each st in s
    //NIKET
    // WriteLine st.toString();
    for (BookData S:s)
      {
	WriteLine (S.toString (), FileName);
      }

  }


  public static void WriteLine (String Line, String Path) throws Exception
  {
    FileWriter fw = new FileWriter (Path);
      fw.write (Line);
      fw.close ();
  }

}


class Prompt
{


  static String ScanString (String a)
  {
    System.out.println (a);
    String b = "";
      try
    {
      b = new Scanner (System.in).nextLine ();
    }
    catch (Exception e)
    {
      System.out.println ("Invalid Input");
      b = ScanString (a);
    }
    return b;
  }


  static int ScanInt (String a)
  {
    System.out.println (a);
    int b = 0;
    try
    {
      b = new Scanner (System.in).nextInt ();
    }
    catch (Exception e)
    {
      System.out.println ("Invalid Input");
      b = ScanInt (a);
    }
    return b;
  }



  static float ScanFloat (String a)
  {
    System.out.println (a);
    Float b = 0.0f;
    try
    {
      b = new Scanner (System.in).nextFloat ();
    }
    catch (Exception e)
    {
      System.out.println ("Invalid Input");
      b = ScanFloat (a);
    }
    return b;
  }



}


class StudentFileReader extends FileReader
{
  /*
     Returns class of books;
     Usage : ReadBookData(<String path of bookfile>)
   */
  static StudentData[] ReadStudentData (String path)
  {
    StudentData[]a = new StudentData[10];
    String data = Read (path);

    int i = 0;
    for (String s:data.split (";"))
      {
            if(s==null)break;
	a[i] =
	  new StudentData (s.split (",")[0], s.split (",")[1], s.split (",")[2],s.split (",")[3],s.split (",")[4],s.split (",")[5]);
	i++;
      }
    return a;
  }



}



class BookFileReader extends FileReader
{
  /*
     Returns class of books;
     Usage : ReadBookData(<String path of bookfile>)
   */
  static BookData[] ReadBookData (String path)
  {
      
    BookData[]a = new BookData[10];
    String data = Read (path);

    int i = 0;
    for (String s:data.split (";"))
    
      {
          if(s==null)break;
	a[i] =
	  new BookData (s.split (",")[0], s.split (",")[1], s.split (",")[2]);
	i++;
      }
    return a;
  }
}





public class Main
{

 
  /*
     NIKET

     - Now use menu driven program to take user choice and the acccess books array and user array

     - Example : To issue for "Nirav"
     - for b in books 
     if b.uID == "Nirav"
     if(b.book1=="")
     b. book1 == <Issue book name>
     else if(b[i].book2=="")
     b. book2 == <Issue book name>
     ... until book 5 
     else Print  Max Issue Limit Achieved i.e. all 5 books are issued.

   */
  public static void main (String[]args)throws Exception
  {
    System.out.println ("Hello World");
     BookData books[] = new BookData[10];	// -> Define in main as books = BookFileReader.ReadBookData()
  StudentData users[] = new StudentData[10];	// same as above for students
    books = BookFileReader.ReadBookData("");
    users = StudentFileReader.ReadStudentData("");
    String sID = "";
     int i=-1;
    sID=Prompt.ScanString("Enter Student Id");
    for( i=0;i<users.length;i++)
        if(sID==users[i].uID)
            break;
    System.out.println("i = "+i)        ;
    if(i==users.length){
        //Invalid ID.
    }
    int k;
    while( (k = Prompt.ScanInt("Enter Operation: \n 1.Issue \n 2.Return a book \n 3.Display List of books \n Others-> Exit."))!=4)
        {
            if(k!=1&&k!=2&&i!=3)break;
            String b = Prompt.ScanString("Enter book name");
            if(k==1){
                if(users[i].book1=="")
                    users[i].book1=b;
                else if(users[i].book2=="")
                    users[i].book2=b;
                else if(users[i].book3=="")
                    users[i].book3=b;
                else if(users[i].book4=="")
                    users[i].book4=b;    
                else if(users[i].book5=="")
                    users[i].book5=b;
                else 
                    System.out.println("Max Capacity reached!Cannot issue any more books");
            }
            else if(k==2) {
                if(users[i].book1==b)
                    users[i].book1="";
                else if(users[i].book2==b)
                    users[i].book2="";
                else if(users[i].book3==b)
                    users[i].book3="";
                else if(users[i].book4==b)
                    users[i].book4="";  
                else if(users[i].book5==b)
                    users[i].book5="";  
                else
                    System.out.println("No such book found for return");
            }
            else{
                for(BookData bo : books)
                    System.out.println(bo.toString());
            }
            
        }
        Writer.WriteBooks("",books);
        Writer.WriteStudents("",users);
  }
}

