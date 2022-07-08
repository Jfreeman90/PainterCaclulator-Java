import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main{
    //function to return the total paintable area for a room depending on walls and obstacles
    static double getPaintableArea() {
        //initialise scanner
        Scanner myScanner = new Scanner(System.in);
        //user input to determine wall size
        System.out.println("Input the height of the wall you need to paint in meters");
        double wallHeight= myScanner.nextDouble();
        System.out.println("Input the width of the wall you need to paint in meters");
        double wallWidth= myScanner.nextDouble();

        //total  wall base area
        double totalArea=wallHeight*wallWidth;

        //ask user if there are any obstructions
        System.out.println("Is there are any obstructions on the wall? 1 for yes/0 for no");
        int obstructionsCheck= myScanner.nextInt();
        //System.out.println(obstructionsCheck);

        //check and work out the value of the wall if obstructions are on the wall
        if (obstructionsCheck==1) {
            //potential obstructions
            System.out.println("Input how many potential obstructions are on the wall - windows, doors, radiators for example.");
            int obstructions = myScanner.nextInt();
            //loop through each obstruction
            for (int i = 0; i < obstructions; i++) {
                //user input
                //ask user the shape of the obstructions
                System.out.println("What shape is the obstruction? 1-Square, 2-Triangle, 3-Circle, 4-Trapezium, 5-Kite");
                int obstructionShape= myScanner.nextInt();
                //System.out.println(obstructionShape);

                //switch case to check between each potential shape and determine the shapes.
                switch (obstructionShape) {
                    //if the obstruction is a square
                    case 1 -> {
                        System.out.println("Input the height of rectangle in meters");
                        double obstructionHeight = myScanner.nextDouble();
                        System.out.println("Input the width of rectangle in meters");
                        double obstructionWidth = myScanner.nextDouble();
                        double obstructionArea = obstructionHeight * obstructionWidth;
                        //update new area
                        totalArea = totalArea - obstructionArea;
                    }
                    //if the obstruction is a triangle
                    case 2 -> {
                        System.out.println("Input the height of triangle in meters");
                        double obstructionTriangleHeight = myScanner.nextDouble();
                        System.out.println("Input the width of triangle in meters");
                        double obstructionTriangleWidth = myScanner.nextDouble();
                        double obstructionTriangleArea = (obstructionTriangleHeight * obstructionTriangleWidth) / 2;
                        //update new area
                        totalArea = totalArea - obstructionTriangleArea;
                    }
                    //if the obstruction is a circle
                    case 3 -> {
                        System.out.println("Input the radius of the circle in meters");
                        double obstructionCircleRadius = myScanner.nextDouble();
                        double obstructionCircleArea = Math.PI * Math.pow(obstructionCircleRadius, 2);
                        //update new area
                        totalArea = totalArea - obstructionCircleArea;
                    }
                    //if the obstruction is trapizeium
                    case 4 -> {
                        System.out.println("Input the vertical height of the trapezium in meters");
                        double obstructionTrapHeight = myScanner.nextDouble();
                        System.out.println("Input the bottom width of the trapezium in meters");
                        double obstructionTrapBotWidth = myScanner.nextDouble();
                        System.out.println("Input the top width of the trapezium in meters");
                        double obstructionTrapTopWidth = myScanner.nextDouble();
                        double obstructionTrapArea = (obstructionTrapBotWidth + obstructionTrapTopWidth) * (obstructionTrapHeight / 2);
                        //update new area
                        totalArea = totalArea - obstructionTrapArea;
                    }
                    //if the obstruction is a kite
                    case 5 -> {
                        System.out.println("Input the vertical height between the two tips in meters");
                        double obstructionKiteHeight = myScanner.nextDouble();
                        System.out.println("Input the horizontal width between the two tips in meters");
                        double obstructionKiteWidth = myScanner.nextDouble();
                        double obstructionKiteArea = (obstructionKiteHeight * obstructionKiteWidth)/4;
                        //update new area
                        totalArea = totalArea - obstructionKiteArea;
                    }
                    //catch an invalid input
                    default ->
                            System.out.println("If you have a shape not listed above then im sorry you're on your own for that wall!");
                }
            }
        } else if (obstructionsCheck==0) {
                return totalArea;
        } else {
            System.out.println("Input error");
        }
        return totalArea;
    }

    // function to find the index of an element in a int array in Java
    public static int find(int[] a, int target)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //function returns largest tins that can be divided into what is needed
    static int biggestTinsWithRemainder(double paintNeededML) {
        int[] paintVolumes = {100, 250, 500, 1000, 1500, 2000, 5000};
        int i=0;
        //catch if needed value is less than what is left so a 100ml bucket is needed
        if (paintNeededML<paintVolumes[0]){
            return paintVolumes[0];
        }
        else {
            while (paintVolumes[i] <= paintNeededML) {
                i++;
                if (i == paintVolumes.length) {
                    return paintVolumes[i - 1];
                }
            }
        }
        return paintVolumes[i-1];
    }

    //function to return totalcost, tin size, tins needed, tin cost, how much paint is left
    static double[] returnArrayOfTinsInfomation(double paintNeededML) {
        int[] paintVolumes = {100, 250, 500, 1000, 1500, 2000, 5000};
        double[] paintPrices = {2.50, 6.00, 10.50, 15.00, 22.50, 28.00, 50.00};
        if (paintNeededML<paintVolumes[0]){
            double[] arr = {paintPrices[0], paintVolumes[0], 1, paintPrices[0], 0};
            return arr;
        }
        double totalCost=0;
        int largestPossibleTin=biggestTinsWithRemainder(paintNeededML);
        //System.out.println("largestPossibleTin"+ largestPossibleTin);
        double tinsWithremainder=Math.floor(paintNeededML/largestPossibleTin);
        //System.out.println("tinsWithremainder"+ tinsWithremainder);
        int getIndexTin = find(paintVolumes, largestPossibleTin);
        //System.out.println("getIndexTin"+ getIndexTin);
        double getTinCost=paintPrices[getIndexTin];
        //System.out.println("getTinCost"+ getTinCost);
        totalCost=getTinCost*tinsWithremainder;
        //System.out.println("totalCost"+totalCost);
        double paintleftover=paintNeededML-(tinsWithremainder*largestPossibleTin);
        //System.out.println("paintNeededML"+paintNeededML);
        //totalcost, tin size, tins needed, tin cost, how much paint is left
        double[] arr = {totalCost, largestPossibleTin, tinsWithremainder, getTinCost, paintleftover};
        return arr;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //paint colours
        String[] paints = {"Green", "Red", "White", "Grey", "Black", "Cream"};
        //paint volumes
        int[] paintVolumes = {100, 250, 500, 1000, 1500, 2000, 5000};
        double[] paintPrices = {2.50, 6.00, 10.50, 15.00, 22.50, 28.00, 50.00};

        //Volume of the paint tin in ml.
        System.out.println("From the list of paint sizes in ml below and their prices enter a number from 1-"+paintVolumes.length+" to indicate the size you would like.");
        System.out.println(Arrays.toString(paintVolumes));
        System.out.println(Arrays.toString(paintPrices));
        int paintVIndex= myScanner.nextInt();

        //check for invalid input
        if (paintVIndex <=0 || paintVIndex>paintVolumes.length);{
            System.out.println("Invalid input - > Program exited: Rerun to try again.");
            System.exit(0);
        }

        float paintTinVolume=paintVolumes[paintVIndex-1];
        System.out.println("Size of tin: " + paintVolumes[paintVIndex - 1] +"ml. Cost " + paintPrices[paintVIndex - 1]);

        //how many square meters 100ml of paint can cover.
        double paintEfficiency=1d;
        //paint variable - how many square meters one tin of paint can cover
        double paintTinEfficiency = (paintTinVolume/100)*paintEfficiency;

        //User chooses the paint colour they would like.
        System.out.println("From the list of paints below enter a number from 1-"+paints.length+" to indicate the colour you would like.");
        System.out.println(Arrays.toString(paints));
        int paintIndex= myScanner.nextInt();
        System.out.println("Paint colour chosen: " + paints[paintIndex - 1]);

        //dealing with the paint selection
        System.out.println("Enter the number of walls you want to paint.");
        int walls= myScanner.nextInt();

        //initialise a total paintable area as 0
        double totalArea=0;

        //loop for each wall using a while loop.
        int wallCounter =0;
        List<Double> wallPaintableAreaList = new ArrayList<>();
        do {
            double paintableArea=getPaintableArea();
            wallPaintableAreaList.add(paintableArea);
            totalArea = totalArea + paintableArea;
            wallCounter++;
        } while (wallCounter<walls);

        //return how many tins of paint needed.
        double mlNeeded=(totalArea/paintEfficiency)*100;
        double tinsNeeded=totalArea/paintTinEfficiency;
        double totalCost=Math.ceil(tinsNeeded)*paintPrices[paintVIndex-1];

        //efficient way of getting the required volume using all possible volumes - in case the customer wants to know.
        double paintNeeded=mlNeeded;
        double totalCostEfficient=0;
        List<Double> tinSizes = new ArrayList<>();
        List<Double> totalTins = new ArrayList<>();
        List<Double> totalTinCost = new ArrayList<>();
        //while there is still paint left keep repeating until less than 0.
        while (paintNeeded >0){
            double[] cheapestTinStats=returnArrayOfTinsInfomation(paintNeeded);
            //update paint needed to the remainder after sharing into the largest tins available.
            paintNeeded=cheapestTinStats[4];
            totalTinCost.add(cheapestTinStats[0]);
            tinSizes.add(cheapestTinStats[1]);
            totalTins.add(cheapestTinStats[2]);
            totalCostEfficient=totalCostEfficient+cheapestTinStats[0];
            //System.out.println(Arrays.toString(cheapestTinStats));
        }

        //System.out.println("Wall dimensions: -> Height:" + wallHeight + "m" + " Width:" + wallWidth + "m");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Taking into account all obstruction the area needed to paint ONE COAT is: " + Math.round(totalArea * 1000.0) / 1000.0 + "m^2");
        //print out array of paintable areas for each wall
        int j=1;
        System.out.println("The area for each wall that requires painting in m^2 in order of walls input");
        for (Double wall : wallPaintableAreaList) {
            System.out.println( "Wall Area " + j + ": " +Math.round(wall * 1000.0) / 1000.0 + "m^2");
            j++;
        }
        System.out.println("You will need " + Math.round(mlNeeded * 1000.0) / 1000.0 + "ml of paint to cover the area");
        System.out.println("You will need " + Math.ceil(tinsNeeded) + " " + paints[paintIndex - 1] + " tins of paint of size " + paintTinVolume + "ml.");
        System.out.println("The total cost for this would be: £" + Math.round(totalCost * 100.0) / 100.0);
        System.out.println("----------------------------------------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Or you could consider the most efficient purchase of tins for the amount of paint needed:");
        System.out.println("Following breakdown for size of tin and the amount of tins needed.");
        for (int i=0; i<tinSizes.size(); i++) {
            System.out.println(totalTins.get(i) + " can(s) of size " + tinSizes.get(i));
        }
        System.out.println("This would cost "+ totalCostEfficient);
        System.out.println("----------------------------------------------------------------------------------------------");

        //ask user if they would like to switch to efficient payment or not.
        System.out.println("Enter 1 if you would like to take the cost effective tins of paint for "+ totalCostEfficient +" Or press 2 for your original cost of " +totalCost);
        int efficientCheck= myScanner.nextInt();
        if (efficientCheck==1){
            totalCost=totalCostEfficient;
        }

        //deal with if user has payment and check for stock.
        System.out.println("How many coats of paint will you need?");
        int howManyCoats= myScanner.nextInt();
        if (howManyCoats==1){
            System.out.println("Then Nothing changes and the total cost is still: £" + Math.round(totalCost * 100.0) / 100.0);
        } else if (howManyCoats==0){
            System.out.println("You cant have zero coats you'll still need one coat the total cost is still: £" + Math.round(totalCost * 100.0) / 100.0);
        } else {
            totalCost = totalCost * howManyCoats;
            System.out.println("Needing "+ howManyCoats + " coats of paint will mean a now cost: £" + Math.round(totalCost * 100.0) / 100.0);
        }

        //ask user for how much money they have and can pay
        System.out.println("How much money do you have?");
        double userMoney= myScanner.nextInt();
        if (userMoney> totalCost || userMoney==totalCost){
            double change =userMoney - Math.round(totalCost * 100.0) / 100.0;
            //user selected to take cost efficient tins
            if (efficientCheck==1){
                System.out.println("TRANSACTION COMPLETED");
                for (int i=0; i<tinSizes.size(); i++) {
                    System.out.println("Sold " + totalTins.get(i) + " can(s) of size " +tinSizes.get(i) + "ml for a total cost of " + totalTinCost.get(i));
                }
                System.out.println("With a total cost: £" + Math.round(totalCost * 100.0) / 100.0);
                System.out.println("User received: £" + change + " change.");

            } else {//user chose to buy original amount of can size.
                System.out.println("TRANSACTION COMPLETE");
                System.out.println("Sold " + Math.ceil(tinsNeeded) + " " + paints[paintIndex - 1] + " tins of paint of size " + paintTinVolume + "ml.");
                System.out.println("With a total cost: £" + Math.round(totalCost * 100.0) / 100.0);
                System.out.println("User received: £" + change + " change");
            }
        } else {
            System.out.println("TRANSACTION INCOMPLETE - Insufficient funds");
        }

    }
}

