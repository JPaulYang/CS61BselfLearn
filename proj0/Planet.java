public class Planet{
	public double xxPos;
	public double yyPos; 
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	private static final double G = 6.67E-11;

	//parameter constructor
	public Planet(double xP,double yP, double xV,double yV,double m,String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	//copy constructor
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	//calculating distance, Math.sqrt used
	public double calcDistance(Planet p){
		double distance = Math.sqrt((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos)
				+(this.yyPos-p.yyPos)*(this.yyPos-p.yyPos));
		return distance;
	}

	//Force exerted by Planet p
	public double calcForceExertedBy(Planet p){
		double force = (G*this.mass*p.mass)/
						(this.calcDistance(p)*this.calcDistance(p));
		return force;
	}

	//合力 net force/resultant force (e.g. of 2 forces)；分力 component of force
	//x-component of the force exerted by Planet p
	public double calcForceExertedByX(Planet p){
		double xxForce = (this.calcForceExertedBy(p)*(p.xxPos-this.xxPos))/
							this.calcDistance(p);
		return xxForce;
	}

	//y-component of the force exerted by Planet p
	public double calcForceExertedByY(Planet p){
		double yyForce = (this.calcForceExertedBy(p)*(p.yyPos-this.yyPos))/
							this.calcDistance(p);
		return yyForce;
	}

	//calculate the net force on x-axis and y-axis
	public double calcNetForceExertedByX(Planet[] p){
		double xxNetForce = 0;
		for(Planet element:p){
			if(this.equals(element)){
				continue;
			}
			xxNetForce += this.calcForceExertedByX(element);
		}
		return xxNetForce;
	}

	public double calcNetForceExertedByY(Planet[] p){
		double yyNetForce = 0;
		for(Planet element:p){
			if(this.equals(element)){
				continue;
			}
			yyNetForce += this.calcForceExertedByY(element);
		}
		return yyNetForce;
	}

	public void update(double time, double xxAddForce, double yyAddForce){
		double xxAcc = xxAddForce/this.mass;
		double yyAcc = yyAddForce/this.mass;
		this.xxVel += time*xxAcc;
		this.yyVel += time*yyAcc;
		this.xxPos += time*this.xxVel;
		this.yyPos += time*this.yyVel;
	}

	//Draw a planet
	public void draw(){
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}
}