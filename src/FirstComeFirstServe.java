import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class FirstComeFirstServe {

    //declaration of global variables
    private static int numberOfProcess;
    private static float averageWaitingTime, averageTurnAroundTime;
    private static float waitingTime, turnAroundTime;
    private static DecimalFormat decimalFormat;
    private static List<Integer> listOfBurstTime;
    private static List<Float> turnAroundTimeList;
    private static Scanner scn;

    public static void main(String[] args) {
        scn = new Scanner(in);

        listOfBurstTime = new ArrayList<>();
        out.println("\n\t\tFIRST COME FIRST SERVE");
        out.print("\nEnter the total number of process: ");

        boolean continueLoop = true;

        while (continueLoop) {
            try {
                numberOfProcess = scn.nextInt();
                continueLoop = false;
            } catch (InputMismatchException e) {
                scn.nextLine();
                err.println("Error! Enter Accepted Integers only!");
            }
        }

        out.println("\n\nEnter the burst time:\n");
        getTheBurstTime();

        out.print("\n\n");

        getTheAverageWaitingTime();
        decimalFormat = new DecimalFormat("0.#");

        out.println("THE AVERAGE WAITING TIME IS: " + decimalFormat.format(averageWaitingTime));

        getTheTotalTurnaroundTime();
        out.print("THE AVERAGE TURNAROUND TIME IS: " + decimalFormat.format(averageTurnAroundTime));

        out.print("\n\n");
        showTheGanttChart();
    }

    private static void showTheGanttChart() {
        out.println("-------------------------------Gantt Chart-------------------------------");
        out.print("PROCESS ");
        for (int index = 0; index < listOfBurstTime.size(); index++)
            out.format("|%2s%5s%5s","","P" +(index + 1),"");
        out.println("|");

        out.print("BURST   ");
        for (int index = 0; index < listOfBurstTime.size(); index++)
            out.format("|%2s%5s%5s","",listOfBurstTime.get(index),"");
        out.println("|");

        out.format("%9s",0);
        for (int index = 0; index < listOfBurstTime.size(); index++) {
            out.format("%13s",decimalFormat.format(turnAroundTimeList.get(index)));
        }

        out.println();

    }

    private static void getTheTotalTurnaroundTime() {
        turnAroundTimeList = new ArrayList<>();
        for (int index = 0; index < listOfBurstTime.size(); index++) {
            turnAroundTime += listOfBurstTime.get(index);

            turnAroundTimeList.add(turnAroundTime);

            averageTurnAroundTime += turnAroundTime;
        }
        averageTurnAroundTime = averageTurnAroundTime / numberOfProcess;
    }

    /**
     * This method will compute the average waiting time for the process
     */
    private static void getTheAverageWaitingTime() {
        for (int index = 0; index < listOfBurstTime.size() - 1; index++) {
            waitingTime += listOfBurstTime.get(index);
            averageWaitingTime += waitingTime;
        }
        averageWaitingTime = averageWaitingTime / numberOfProcess;
    }

    /**
     * When the user input a value for each process, this method will do the behind the scenes of getting it and store it
     * in a List of Array
     */
    private static void getTheBurstTime(){
        for (int index = 0; index < numberOfProcess; index++) {
            out.print("P[" + (index + 1) + "]: ");
            int burstTime = 0;
            boolean continueLoop = true;
            while (continueLoop) {
                try {
                    burstTime = scn.nextInt();
                    continueLoop = false;
                } catch (InputMismatchException e) {
                    scn.nextLine();
                    err.println("Error! InputMismatchException handled. Please enter accepted integers only");
                }
            }
            listOfBurstTime.add(burstTime);
        }
    }
}
