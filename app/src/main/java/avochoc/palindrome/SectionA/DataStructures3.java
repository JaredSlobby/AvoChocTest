package avochoc.palindrome.SectionA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DataStructures3 
{
    private static final int MAX_LEVEL = 16; // Maximum level for the skip list
    private Node head; // Head node of the skip list
    private int level; // Current level of the skip list

    public static void main(String[] args) 
    {
        DataStructures3 ds3 = new DataStructures3();
        ds3.fillFromFile("app/src/main/resources/datastructures3.csv");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of the movie:");
        String movieTitle = scan.nextLine();

        List<String> matchingMovies = ds3.search(movieTitle);
        if (!matchingMovies.isEmpty()) {
            System.out.println("Movies found in the skip list:");
            for (String movie : matchingMovies) 
            {
                System.out.println(movie);
            }
        } 
        else 
        {
            System.out.println("No movies found in the skip list matching the given title.");
        }
        scan.close();
    }

    public DataStructures3() 
    {
        this.head = new Node(null, MAX_LEVEL);
        this.level = 0;
    }

    public void insert(String title) 
    {
        //Randomly generate the level for new node
        int newLevel = randomLevel();
    
        Node newNode = new Node(title, newLevel);
    
        // Update the level if necessary
        if (newLevel > level) {
            level = newLevel;
        }
    
        //An arry to store update nodes
        Node[] update = new Node[level]; 
        //Initialize update array with head node 
        Arrays.fill(update, head);
    
        Node current = head;
        for (int i = level - 1; i >= 0; i--) 
        {
            while (current.forward[i] != null && current.forward[i].title.compareTo(title) < 0) 
            {
                //Moving forward in level until correct position is found
                current = current.forward[i];
            }
            update[i] = current;
        }
        //Fixing update and new nodes forward references
        for (int i = 0; i < newLevel; i++) 
        {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public void fillFromFile(String filePath) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                // Removing any whitespaces
                line = line.trim(); 
                if (!line.isEmpty()) 
                {
                    //Inserting the newly trimmed line without any whitespaces into skip list
                    insert(line);
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public List<String> search(String title) 
    {
        //Array list to store matching movie titles
        List<String> matchingTitles = new ArrayList<>();
        //Starting the search from head of skip list
        Node current = head;
        for (int i = level - 1; i >= 0; i--) 
        {
            while (current.forward[i] != null && current.forward[i].title.compareTo(title) < 0) 
            {
                //Moves forward in the skip list until node with greater title is found
                current = current.forward[i];
            }
            if (current.forward[i] != null && current.forward[i].title.startsWith(title)) 
            {
                
                Node matchNode = current.forward[i];
                while (matchNode != null && matchNode.title.startsWith(title)) 
                {
                    //Adding matching title to matchingTitles List
                    matchingTitles.add(matchNode.title);
                    //Move to next node that has matching title
                    matchNode = matchNode.forward[i];
                }
            }
        }
        //Returning all matching titles        
        return matchingTitles;
    }
    

    private int randomLevel() 
    {
        int level = 0;
        //Creating random number generator
        Random rand = new Random();
        //Generates a random number between 0.0 and 1.0, the while statement will check if it is less than 0.5
        while (level < MAX_LEVEL && rand.nextDouble() < 0.5)
        {
            //Level will be increased as long as it is smaller than the MAX_LEVEL(16)
            level++;
        }
        //Returns random level that was generated
        return level;
    }

    private class Node 
    {
        private String title;
        private Node[] forward;

        public Node(String title, int level) 
        {
            this.title = title;
            this.forward = new Node[level];
        }
    }
}
