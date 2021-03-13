/*****************************************************************
	Complex2:  TwoStep revisited... combining TickerBehaviour
	--------     SequentialBehaviour and WakerBehaviour
	
    Author:  Jean Vaucher
    Date:    Sept 1 2003 
*****************************************************************/
package classes.TickerandWaker;

import jade.core.Agent;
import jade.core.behaviours.*;

import java.util.Random;

public class Complex2 extends Agent 
{
	long      t0 = System.currentTimeMillis();
	Random rnd = new Random();
	Behaviour loop;
	
	protected void setup() 
	{
	// ------------- Looping part --------------------------------
	
		loop = new TickerBehaviour( this, 300 )
			{
				protected void onTick() {
					System.out.println( System.currentTimeMillis()-t0 +
						": " + myAgent.getLocalName());
				}
			};
		
		addBehaviour( loop );
		
	// ------------- Sequential part --------------------------------

		addBehaviour( new WakerBehaviour( this, (long)(2000*rnd.nextFloat()) )
			{
				protected void handleElapsedTimeout() {
					System.out.println( System.currentTimeMillis()-t0 +
						": " + "... Message1");
						
					myAgent.addBehaviour( new WakerBehaviour( myAgent, 500 )
					{
						protected void handleElapsedTimeout() {
							System.out.println( System.currentTimeMillis()-t0 +
								": " + "  ...and then Message 2");
							myAgent.removeBehaviour( loop );
						}
					});
				}
			});
		
		
	}
}
