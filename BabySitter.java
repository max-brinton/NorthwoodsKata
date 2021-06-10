import java.util.ArrayList;
import java.util.Scanner;


class BabySitter {
    public static void main (String args[]) {
        


        // Some variables we will need
        int totalPay = 0;
        int totalHours = 0;
        int endTime = 16;
        boolean check = false;
        final int startPay = 12;
        final int bedPay = 8;
        final int afterPay = 16;



        // Create ArrayList of valid times [5,6,7,8,9,10,11,12,13,14,15,16]
        ArrayList<Integer> validTimeList = new ArrayList<Integer>();
        for (int i = 5; i < 17; i++) {
            validTimeList.add(i);
        }

        System.out.println("Valid times to pick: "+ validTimeList);



        // Get start time 
        Scanner in = new Scanner(System.in);
        System.out.println("Enter start time: ");
        int startTime = in.nextInt();

        // Validate start time
        while (!validTimeList.contains(startTime)) {
            System.out.println("Please enter a valid start time: ");
            startTime = in.nextInt();
        }



        // Calculate after-hour pay if the babysitter were to start their shift after midnight
        if (startTime > 11) {

            // Get end time
            System.out.println("Please enter an end time: ");
            endTime = in.nextInt();

            while (!check) {

                //make sure end time is valid input
                if (!validTimeList.contains(endTime)) {
                    System.out.println("Please enter a valid end time: ");
                    endTime = in.nextInt();
                }

                //make sure end time is not before start time
                else if (endTime < startTime) {
                    System.out.println("End time is before start time. Please enter a valid end time: ");
                    endTime = in.nextInt();
                } 

                //end time is valid, calulate after-hour pay and previous pay
                else {
                    totalHours = endTime - startTime;
                    totalPay = totalHours * afterPay;

                    check = true;
                }
            }

            // Output total pay
             System.out.println("Your total pay is $" + totalPay);

         }


        // Babysitter started before midnight. Calculate start pay, bedtime pay, and after-hour pay
        else {

            // Get bedtime 
            System.out.println("Enter a bedtime: ");
            int bedTime = in.nextInt();

            // Validate bedtime
            while (!check) {

                //make sure bedtime is valid input
                if (!validTimeList.contains(bedTime)) {
                    System.out.println("Please enter a valid bedtime: ");
                    bedTime = in.nextInt();
                }

                //make sure bedtime is not before start time
                else if (bedTime < startTime) {
                    System.out.println("Bedtime is before start time. Please enter a valid bedtime: ");
                    bedTime = in.nextInt();
                } 

                //make sure bedtime is not after midnight
                else if (bedTime > 11) {
                    System.out.println("Bedtime needs to be before 12. Please enter a valid bedtime: ");
                    bedTime = in.nextInt();
                } 

                //bedtime is valid, calculate pay from start to bedtime
                else {
                    totalHours = bedTime - startTime;
                    totalPay = (totalHours * startPay);
                    check = true;
                }

            }


            //Get end time 
            System.out.println("Please enter an end time: ");
            endTime = in.nextInt();

            check = false;
            while (!check) {
                
                //make sure end time is valid input
                if (!validTimeList.contains(endTime)) {
                    System.out.println("Please enter a valid end time: ");
                    endTime = in.nextInt();
                }

                //make sure end time is not before start time
                else if (endTime < bedTime) {
                    System.out.println("End time is before bed time. Please enter a valid end time: ");
                    endTime = in.nextInt();
                } 

                //end time is valid, calulate after hour pay and add to the total pay so far
                else {

                    //end time is before midnight (so no after-hour pay)
                    if (endTime > 11) {
                        //calculate bed time pay
                        totalHours = 12 - bedTime;
                        totalPay += (totalHours * bedPay);

                        //calculate after hour pay (the final payout)
                        totalHours = endTime - 12;
                        totalPay += (totalHours * afterPay);
                    } 

                    //end time is after midnight
                    else {
                        totalHours = endTime - bedTime;
                        totalPay += totalHours * bedPay;
                    }

                    check = true;
            }

        } 

        //Output total pay
        System.out.println("Your total pay is $" + totalPay);

        
    }

    in.close();
}
}

