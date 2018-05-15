package domain.value;

public class AverageScore extends Value{

	private float averageScore;

	/* コンストラクタ */
	public AverageScore(float averageScore){
		super();
		this.averageScore = averageScore;
	}

	/* getメソッド */
	public float getValue(){
		return averageScore;
	}

	/* toStringメソッド */
	@Override
	public String toString(){
		return String.valueOf(averageScore);
	}

//	/* コンストラクタ */
//	public AverageScore(List<Score> scores) {
//		super(averageScore(scores));
//	}
//
//	private float averageScore(List<Score> scores){
//		float sum = 0;
//		int count = 0;
//
//		for(Score score:scores){
//			sum += score.getValue();
//			count++;
//		}
//
//		float average = sum / count;
//		return average;
//	}
}
