import java.util.ArrayList;
import java.util.Collections;

public class JobSequencingProblem {
    public static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

    }

    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sort jobs by profit in descending order
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        ArrayList<Job> result = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job currentJob = jobs.get(i);

            if (currentJob.deadline > time) {
                result.add(currentJob);
                time++;
            }
        }
        System.out.println("Selected jobs:");
        for (Job job : result) {
            System.out.println("Job ID: " + job.id + ", Deadline: " + job.deadline + ", Profit: " + job.profit);
        }
    }
}

// Tc : O(n log n) for sorting, O(n) for the selection process
// Sc : O(n) for storing the jobs and the result