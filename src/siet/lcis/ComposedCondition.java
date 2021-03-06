package siet.lcis;

import java.util.Map;

public class ComposedCondition extends Condition {
	protected Condition mC1;
	protected Condition mC2;
	protected String mType;
	
	ComposedCondition(String pId, String pType, Condition pC1, Condition pC2)
	{
		super(pId);
		mType = pType;
		mC1 = pC1;
		mC2 = pC2;
	}

	@Override
	public boolean match(WorldModel pWM) {
		if (mType.equals("and"))
		{
			return mC1.match(pWM) && mC2.match(pWM);
		}
		else if (mType.equals("or")) 
		{
			return mC1.match(pWM) || mC2.match(pWM);
		}
		else
		{
			System.err.println("Internal error, invalid ComposedCondition type: ["+mType+"]");
		}
		return false;
	}

	@Override
	public Map<String, Long> getKnowledgesHistoryTimes() {
		Map<String, Long> result = mC1.getKnowledgesHistoryTimes();
		result.putAll(mC2.getKnowledgesHistoryTimes());
		return result;
	}
	
	

}
