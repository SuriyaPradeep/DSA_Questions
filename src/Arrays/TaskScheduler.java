package Arrays;
/*
You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
Return the minimum number of intervals required to complete all tasks.
Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have passed.
 */
public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        int max=0,maxCount=0;
        //Max Keeps count of maximum occurance
        //MaxCount keeps how many max occurence are there
        for(char task:tasks){
            count[task-'A']++;
            if(max==count[task-'A']){
                maxCount++;
            }else if(max<count[task-'A']){
                max=count[task-'A'];
                maxCount=1;
            }
        }
        int partCount=max-1;
        int partLength=n-(maxCount-1);
        int emptySlots=partCount*partLength;
        int availableTasks=tasks.length-max*maxCount;
        int idleSlots=Math.max(0,emptySlots-availableTasks);
        return tasks.length+idleSlots;
    }

    public static void main(String[] args) {
        char[] tasks={'A','A','A','B','B','B'};
        int n=2;
        System.out.println(leastInterval(tasks,n));//8
    }
}
