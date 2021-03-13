/*****************************************************************
	Sequence1:  Sequentiality obtained by adding a second behaviour 
	---------      when the preceding one finishes
	
    Author:  Jean Vaucher
    Date:    Sept 1 2003 
*****************************************************************/
package classes.TickerandWaker;

import jade.core.Agent;
import jade.core.behaviours.*;


public class Sequence1 extends Agent 
{
	long t0 ;
	long time() { return System.currentTimeMillis()-t0; }
	
	protected void setup() 
	{
		addBehaviour( new WakerBehaviour( this, 250 )
			{
				protected void handleElapsedTimeout() 
				{
					System.out.println( time() + ": " + "... Message1");
					addBehaviour( new WakerBehaviour( myAgent, 500 )
						{
							protected void handleElapsedTimeout() {
								System.out.println( time() + ": " + "  ...and then Message 2");
							}
						});
				}
			});
		t0 = System.currentTimeMillis();
	}
}
