/*****************************************************************
	Sequence:  Use of a WakerBehaviours to schedule 2 events
	--------
    Author:  Jean Vaucher
    Date:    Sept 1 2003 
*****************************************************************/
package classes.TickerandWaker;

import jade.core.Agent;
import jade.core.behaviours.*;


public class Sequence extends Agent 
{
	long      t0 = System.currentTimeMillis();
	
	protected void setup() 
	{
		addBehaviour( new WakerBehaviour( this, 250 )
			{
				protected void handleElapsedTimeout() {
					System.out.println( System.currentTimeMillis()-t0 +
						": " + "... Message1");
				}
			});
		
		addBehaviour( new WakerBehaviour( this, 750 )
			{
				protected void handleElapsedTimeout() {
					System.out.println( System.currentTimeMillis()-t0 +
						": " + "  ...and then Message 2");
				}
			});
	}
}
