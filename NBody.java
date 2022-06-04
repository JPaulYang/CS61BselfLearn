public class NBody{

	//read the radius of universe in the text file
	public static double readRadius(String textFile){
		In in = new In(textFile);
		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	//read the Planets in the text file
	public static Planet[] readPlanets(String textFile){
		In in = new In(textFile);
		int size = 5;		//5 planets in total
		Planet[] planets = new Planet[size];
		int i = 0;			//index

		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();
		double xxPos;
		double yyPos;
		double xxVel;
		double yyVel;
		double mass;
		String imgFileName;
		/**There are some description below the data sheet. 
		 * These words will make in.isEmpty() to be false 
		 * AFTER in read the last image file name.
		 * Therefore, we need to restrict the index i to be less than size(5).
		 * @author Jiannan Yang
		 */
		while(!in.isEmpty() &&i<size){
			xxPos = in.readDouble();
			yyPos = in.readDouble();
			xxVel = in.readDouble();
			yyVel = in.readDouble();
			mass = in.readDouble();
			imgFileName = in.readString();
			//use constructor to construct.
			planets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
			//move to the next line
			i++;
		}
		return planets;
	}


	//Drawing the Initial Universe State (main method)
	public static void main(String[] args){
		// Double.parseDouble convert the String to a double value.
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		//read the radius and planets
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		//Draw the canvas/background with StdDraw.
		/* API: Application Programming Interface
		应用程序接口
		*/
		StdDraw.setScale(-radius,radius);
		StdDraw.clear();
		StdDraw.picture(0,0,"./images/starfield.jpg");
		for(Planet p:planets){
			p.draw();
		}

		/**double buffering 双重缓存（冲）
		*  This is a graphics technique to prevent flickering （闪烁） 
		*  in the animation.
		*/
		StdDraw.enableDoubleBuffering();

		//Discretize time
		double t = 0.0;
		while(t<=T){
			double[] xForces = new double[5];
			double[] yForces = new double[5];
			for(int i =0;i < 5;i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			//update the velocity and position
			for(int j = 0;j < 5;j++){
				planets[j].update(dt,xForces[j],yForces[j]);
			}
			//Draw the picture again (updated)
			StdDraw.picture(0,0,"./images/starfield.jpg");
			for(Planet p:planets){
				p.draw();
			}
			//show the off screen buffer
			StdDraw.show();
			//Pause the animation for 10 seconds
			StdDraw.pause(10);

			t += dt;

		}

	}

}