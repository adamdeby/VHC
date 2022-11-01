
public class Job {

	private int jobDuration;
	private int jobID;
	private int computeCompletionTime;
	
	public Job(int jobDuration, int jobID) {
		this.jobDuration = jobDuration;
		this.jobID = jobID;
	}
	
	
	public int getJobDuration() {
		return jobDuration;
	}


	public void setJobDuration(int jobDuration) {
		this.jobDuration = jobDuration;
	}


	public int getJobID() {
		return jobID;
	}


	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	
	//returns the completion time for the jobs
	public int computeCompletionTime() {
		return computeCompletionTime;
	}
	
	
	
}
