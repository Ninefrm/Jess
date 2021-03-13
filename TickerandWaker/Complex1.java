/*****************************************************************
	Complex1:  Use of a TickerBehaviour
	--------
    Author:  Jean Vaucher
    Date:    Sept 1 2003 
*****************************************************************/
package classes.TickerandWaker;

import jade.core.Agent;
import jade.core.behaviours.*;


public class Complex1 extends Agent 
{
	long      t0 = System.currentTimeMillis();
	Behaviour loop;
	
	protected void setup() 
	{
		loop = new TickerBehaviour( this, 300 )
			{
				protected void onTick() {
					System.out.println( System.currentTimeMillis()-t0 +
						": " + myAgent.getLocalName());
				}
			};
		
		addBehaviour( loop );
	}
}
