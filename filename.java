import java.util.Scanner;

public class EEProgram {
	
	static float baseTa, baseTm, baseRiam, baseAm, baseAa;
	static float curTa, curTm, curRiam, curAm, curAa;
	static float deltaTa, deltaTm, deltaRiam, deltaAm, deltaAa;
	

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    	System.out.println("Step 1 : Perform no load test & input Timing data \n");
    	
    	
    	System.out.println ("Decision 1 : Is Contact mismatch beyond specified limits? (y/n) : ");
        String contactMismatch = scanner.next();
        
        
        
        if (contactMismatch.equalsIgnoreCase("n")) {
        	System.out.println("Step 2 : Measure static contact resistance & perform DCRM \n");
        	System.out.println ("Decision 2 : Are noticeable variations in close zone? (y/n) : ");
            String notVariations = scanner.next();
            
            
        	
        	if (notVariations.equalsIgnoreCase("y")) {
        		System.out.println ("Decision 3 : 50 Hz frequency variations in close zone? (y/n) : ");
                String freqVar = scanner.next();
                
                if (freqVar.equalsIgnoreCase("y")) {
                	System.out.println("Action required : Induction effect Remedial action: Give one turn on insulator for current cable to avoid interference.\n\n");
                	System.exit(0);
                } else if (freqVar.equalsIgnoreCase("n")) {
                	//do nothing
                } else {
                	System.out.println("Incorrect value entered. Please enter 'y' or 'n'. \n\n");
                	System.exit(0);
                }
        		
        	} else if (notVariations.equalsIgnoreCase("n")) {
        		System.out.println ("Decision 3 : Is contacts bouncing & breaking in closing/opening? (y/n) : ");
                String contBounce = scanner.next();
                
                if (contBounce.equalsIgnoreCase("y")) {
                	System.out.println ("Decision 3 : 50 Hz frequency variations in close zone? (y/n) : ");
                    String freqVar1 = scanner.next();
                    
                    if (freqVar1.equalsIgnoreCase("y")) {
                    	System.out.println("Action required : Induction effect Remedial action: Give one turn on insulator for current cable to avoid interference.\n\n");
                    	System.exit(0);
                    } else if (freqVar1.equalsIgnoreCase("n")) {
                    	//do nothing
                    } else {
                    	System.out.println("Incorrect value entered. Please enter 'y' or 'n'. \n\n");
                    	System.exit(0);
                    }
                	
                	
                } else  if (contBounce.equalsIgnoreCase("n")) {
                	//do nothing
                } else {
                	System.out.println("Incorrect value entered. Please enter 'y' or 'n'. \n\n");
                	System.exit(0);
                }
                
        		
        	} else {
            	System.out.println("Incorrect value entered. Please enter 'y' or 'n'. \n\n");
            	System.exit(0);
            }
        	
        	System.out.println("Step 3 : Measure contact wipe with slow closing & make it to specified value \n");    
            System.out.println("Step 4 : Repeat DCRM \n");  
            System.out.println ("Decision 4 : Is Normal Signature? (y/n) : ");
            String normSig = scanner.next();
            
            if (normSig.equalsIgnoreCase("y")) {
            	System.out.println("Output : Breaker is healthy.\n\n");
            	System.exit(0);
            } else if (normSig.equalsIgnoreCase("n")){
            	
            	//TODO calculate deltas
            	System.out.println("\n\n Please enter the BASE values below:\n Enter base Tm : ");
            	baseTm = Float.parseFloat(scanner.next());
            	
            	System.out.println("Enter base Ta : ");
            	baseTa = Float.parseFloat(scanner.next());

            	System.out.println("Enter base Riam : ");
            	baseRiam = Float.parseFloat(scanner.next());
            	
            	System.out.println("Enter base Am : ");
            	baseAm = Float.parseFloat(scanner.next());
            	
            	System.out.println("Enter base Aa : ");
            	baseAa = Float.parseFloat(scanner.next());
            	
            	System.out.println("\n\n Please enter the CURRENT values below:\n Enter current Tm : ");
            	curTm = Float.parseFloat(scanner.next());
            	
            	System.out.println("Enter current Ta : ");
            	curTa = Float.parseFloat(scanner.next());

            	System.out.println("Enter current Riam : ");
            	curRiam = Float.parseFloat(scanner.next());
            	
            	System.out.println("Enter current Am : ");
            	curAm = Float.parseFloat(scanner.next());
            	
            	System.out.println("Enter current Aa : ");
            	curAa = Float.parseFloat(scanner.next());
            	
            	System.out.println("\nCalculating delta values (current - base)... ");
            	
            	deltaTm = curTm - baseTm;
            	deltaTa = curTa - baseTa;
            	deltaRiam = curRiam - baseRiam;
            	deltaAm = curAm - baseAm;
            	deltaAa = curAa - baseAa;
            	
            	
            	System.out.println("Difference Tm : " + deltaTm + " \n");
            	System.out.println("Difference Ta : " + deltaTa + " \n");
            	System.out.println("Difference Riam : " + deltaRiam + " \n");
            	System.out.println("Difference Am : " + deltaAm + " \n");
            	System.out.println("Difference Aa : " + deltaAa + " \n\n");
            	
            	System.out.println("\n\n Checking conditions...\n\n ");
            	
            	if  ((deltaTm < 0) && (deltaRiam == 0) && (deltaAa > 0) && (deltaTa==0) && (deltaAm>0) )  {
            		System.out.println("PROBLEM 1 detected : Main contact erosion. ");
            	}
            	
            	if ((deltaTm==0) && (deltaRiam ==0) && (deltaAa<0) && (deltaTa<0) && deltaAm==0) {
            		System.out.println("PROBLEM 2 detected : Fix arcing contact erosion. ");
            	}
            	
            	if ((deltaTm==0) &&(deltaRiam>0) && (deltaAa>0) && (deltaTa==0) && (deltaAm==0)) {
            		System.out.println("PROBLEM 3 detected : Wearing of arcing contact fingers. ");
            	}
            	
            	if ((deltaTm==0) && (deltaRiam>0) && (deltaAa<0) && (deltaTa<0) && (deltaAm==0)) {
            		System.out.println("PROBLEM 4 detected : Fix and moving  arc contact erosion. ");
            	}
            	
            	if ((deltaTm<0)&&(deltaRiam>0) &&(deltaAa<0) &&(deltaTa<0) && (deltaAm>0)) {
            		System.out.println("PROBLEM 5 detected : Arc contact -Fix and moving- and main contact erosion. ");
            	}
            	
            	System.out.println("\n ***** Execution complete *****\n ");
            	System.exit(0);
            	
            } else {
            	System.out.println("Incorrect value entered. Please enter 'y' or 'n'. \n\n");
            	System.exit(0);
            }
        	
        	
            	
        } else if (contactMismatch.equalsIgnoreCase("y")) {
        	System.out.println("Action required : Adjust mechanism setting.\n\n");
        	System.exit(0);
        } else {
        	System.out.println("Incorrect value entered. Please enter 'y' or 'n'. \n\n");
        	System.exit(0);
        }
        
        
        System.exit(0);

    }

}
