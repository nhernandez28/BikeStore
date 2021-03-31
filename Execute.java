import java.util.*;
import java.io.*;
import java.lang.*;

public class Execute {
    public static void main(String[] args) {

    
        //Reads inventory file and
        System.out.println("Remaining Inventory: ");
        Bike[] inventory = readInventoryFromFile("Inventory.txt");
        System.out.println();
        //Updates bike inventory after selling based off clients request file, then creates an order file for bikes missing from inventory
        double profit = updateInventoryBasedOnClientsRequests(inventory, "ClientRequest.txt", "BikeOrder.txt");
        System.out.println("Profit: " + profit);
        System.out.println();
        //prints the remaining inventory after a client buys a bike;  
        printInventory(inventory);
    }

    public static Bike[] readInventoryFromFile(String filename) {
        //creates and returns a Bike array to make the file run syntactially correct, this Bike array will never be accessed  
        Bike[] ex = new Bike[0];

        try {
            //creates the file reader to read the inventory .txt  
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            String[] r = new String[1];
            //reads the file and counts the lines in order to get the size of the array  
            int count = 0;
            while ((str = br.readLine()) != null) {
                count++;
            }
            //close and resterts the file reader in order to reset the read data  
            br.close();
            f = new File(filename);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            //creates a 2d string array where each row represents a Bike and each of the 10 columns is an attribute to the Bike  
            String[][] bInfo = new String[count][10];
            int i = 0;
            while ((str = br.readLine()) != null) {
                r = str.split(", ");
                bInfo[i] = r;
                i++;
            }
            br.close();
            //converts the 2d string array into a Bike array  
            Bike[] inventory = new Bike[count];
            for (int j = 0; j < bInfo.length; j++) {
                //switch case converts each row of the 2d array into a Bike depending on what type of bike it is   
                switch (bInfo[j][0]) {
                    case "Mountain Bike":
                        MountainBike mb = createMountainBike(bInfo[j]);
                        inventory[j] = mb;
                        break;
                    case "Road Bike":
                        RoadBike rb = createRoadBike(bInfo[j]);
                        inventory[j] = rb;
                        break;
                    case "City Bike":
                        CityBike cb = createCityBike(bInfo[j]);
                        inventory[j] = cb;
                        break;
                }
            }
            return inventory;
            //catches any input or output exception and prints   
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
            //catches NumberFormat Exception and prints   
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.exit(0);
            //catches Array IndexOutOfBoundsException and prints  
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("error");
            System.exit(0);
        }
        return ex;
    }



    public static double updateInventoryBasedOnClientsRequests(Bike[] B, String fileIn, String fileOut) {
        //initializes profit return 
        double profit = 0.0;
        try {
            //creates a file reader to read the clients request file   
            File fi = new File(fileIn);
            FileReader fr = new FileReader(fi);
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            String[] r = new String[1];
            //count used to determine size of array   
            int count = 0;
            while ((str = br.readLine()) != null) {
                count++;
            }
            //closes and re-opens file readers to reset memory that was read   
            br.close();
            fi = new File(fileIn);
            fr = new FileReader(fi);
            br = new BufferedReader(fr);

            //creates a string arrayand stores the qualities of the bike given by the client 
            String[][] clientInfo = new String[count][4];
            int i = 0;
            while ((str = br.readLine()) != null) {
                r = str.split(", ");
                clientInfo[i] = r;
                i++;
            }
            br.close();

            //creates an array to find the profit of selling one of each bike in your inventory   
            double[] profitA = new double[B.length];
            for (int j = 0; j < B.length; j++) {
                profitA[j] = B[j].getRetailCost() - B[j].getPurchaseCost();
            }

            //this loop goes through each Bike in the Bike array   
            for (int j = 0; j < B.length; j++) {
                int a = 0;
                //this loop goes through each bike in the client request info array  
                while (a < clientInfo.length) {
                    //this if will update the inventory and calculate profit  
                    if (clientInfo[a][1].equals(B[j].getModelNum()) && clientInfo[a][2].equals(B[j].getColor())) {

                        //number of bikes client wants
                        int tempClient = Integer.parseInt(clientInfo[a][3]);

                        //subtract to update clientInfo to the amount of bikes they need still
                        int bikesNeeded = Integer.parseInt(clientInfo[a][3]) - B[j].getNumInv();

                        //makes the bikes still needed only positive integers, because if negative we would not need more bikes 
                        if (bikesNeeded < 0) {
                            bikesNeeded = 0;
                        }

                        //updates profit based on how many bikes were sold and at what price
                        profit += (tempClient - bikesNeeded) * profitA[j];

                        //updates the bikes that   
                        clientInfo[a][3] = Integer.toString(bikesNeeded);

                        //updates bike inventory after bike sold
                        B[j].setNumInv(B[j].getNumInv() - tempClient);

                        //sets inventory to 0 if client requested more bikes then we have
                        if (B[j].getNumInv() < 0) {
                            B[j].setNumInv(0);
                        }

                    }
                    a++;
                }
            }
            //creates file writer to create a file and write the bike order  
            File f = new File(fileOut);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            //writes the bikes that need to be ordered to a new file   
            bw.write("Bike Order:\n");
            for (int j = 0; j < clientInfo.length; j++) {
                if (Integer.parseInt(clientInfo[j][3]) > 0) {
                    bw.write(clientInfo[j][0] + ", " + clientInfo[j][1] + ", " + clientInfo[j][2] + ", " + clientInfo[j][3] + "\n");
                }
            }
            bw.close();
            //same exceptions as the ones in the read inventory method
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            System.exit(0);
        }
        return profit;
    }

    //prints out the inventory remaining bikes  
    public static void printInventory(Bike[] B) {
        for (int i = 0; i < B.length; i++) {
            if (B[i].getNumInv() > 0)
                System.out.println(B[i].toString());
        }
    }

    //methods used to create a Mountain Bike, Road Bike, and City Bike with a string array given  
    public static MountainBike createMountainBike(String[] a) {
        MountainBike mb = new MountainBike(a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8], a[9]);
        return mb;
    }
    public static RoadBike createRoadBike(String[] a) {
        RoadBike rb = new RoadBike(a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8], a[9]);
        return rb;
    }
    public static CityBike createCityBike(String[] a) {
        CityBike cb = new CityBike(a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8], a[9]);
        return cb;
    }
}