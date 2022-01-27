import java.util.Collections;
import java.util.List;

public class ShowHandStrategy {
	private static ShowHandStrategy instance=null;
	private Service server = null;
	
	public static ShowHandStrategy getInstance() {
		if (instance == null) {
			instance = new ShowHandStrategy();
		}
		
		return instance;
	}
	
	public static ShowHandStrategy getInstance(Service service) {
		getInstance();
		instance.server = service;
		return instance;
	}
	
	

	public void requireDraw(List<Card> currentCards) {
		// TODO Auto-generated method stub
		List<Integer> possiblePoints = getPossiblePoints(currentCards);
		Collections.sort(possiblePoints, Collections.reverseOrder());
		if (possiblePoints==null) {
			this.server.giveUp(0);
			return;
		}
		if (possiblePoints.get(0) == 21) {
			this.server.done(0);
		} else {
			if (possiblePoints.get(0)> 16) {
				this.server.done(0);
				return;
			} else {
				this.server.draw(0);
				return;
			}
		}
	}

	private List<Integer> getPossiblePoints(List<Card> currentCards) {
		// TODO Auto-generated method stub
		return null;
	}
}
