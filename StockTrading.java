  /*
   * StockTrading Java Class
   * By Mukund Raman
   */

  import java.util.*;
  import java.text.SimpleDateFormat;
  import java.text.*;
  import java.text.NumberFormat;

  public class StockTrading {
    
     Scanner input = new Scanner(System.in);
    
    // Makes a private static integer value to 10 Million for money
    private static double MONEY = 10000000;
    
    private static double AAPLval = 172.43;
    private static double AMZNval = 1448.69;
    private static double GBTCval = 17.76;
    private static double BABAval = 183.68;
    private static double COSTval = 191.56;
    private static String timeStamp = new SimpleDateFormat("MM_dd_yyyy").format(Calendar.getInstance().getTime());
    private static int transactionNumber = 0;
    private ArrayList<Double> stockPriceWhenBoughtArray = new ArrayList<Double>(5);
    private ArrayList<String> whichStockBoughtArray1 = new ArrayList<String>(5);
    private ArrayList<Integer> totalNumOfStocksBoughtArray = new ArrayList<Integer>(5);
    private ArrayList<String> currentTimeWhenBought = new ArrayList<String>(5);
    private ArrayList<String> buyOrsell = new ArrayList<String>(5);
    private ArrayList<Double> totalPrice = new ArrayList<Double>(5);
    private ArrayList<Double> WAPcount = new ArrayList<Double>();
    private int factor;
    private static int stockAAPLval = 0;
    private static int stockAMZNval = 0;
    private static int stockGBTCval = 0;
    private static int stockBABAval = 0;
    private static int stockCOSTval = 0;
    Double WAP = (double)0;
    
    protected void menuOptions() {
      System.out.println("Stock Trading System version 1.0");
      System.out.println("Created by: Mukund Raman\n\n");
      System.out.println("Welcome to the virtual stock trading system");
      System.out.println("\nMenu:");
      System.out.println("\nOption 1: Trade");
      System.out.println("Option 2: Show Trade History");
      System.out.println("Option 3: Quit\n");
	    
			Timer timer = new Timer();
			timer.schedule(
				new TimerTask(){
					@Override
					public void run() {
						double start = 100;
						double end = 250;
						double random = new Random().nextDouble();
						double result = start + (random * (end - start));
						DecimalFormat df = new DecimalFormat("##.##");
						String dfresult = df.format(result);
						Double result1 = Double.parseDouble(dfresult);
						AAPLval = result1;      
					}
				}
			, 30000);

			run1();
			run2();
			run3();
			run4();
		
      NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
      System.out.println("\nAmount of Money Left: " + "$" + numberFormat.format(Math.round(MONEY * 100.000)/100.000));
      System.out.println("\nAmount of AAPL stocks: " + stockAAPLval);
      System.out.println("Amount of AMZN stocks: " + stockAMZNval);
      System.out.println("Amount of GBTC stocks: " + stockGBTCval);
      System.out.println("Amount of BABA stocks: " + stockBABAval);
      System.out.println("Amount of COST stocks: " + stockCOSTval);
      
      System.out.println("Please enter the number of the option you would like:\n");
      
      int input1 = input.nextInt();
      
      if(input1 != 1 && input1 != 2 && input1 != 3) {
        
        System.out.println("You have entered a wrong number. Please try again.");
        menuOptions();
        
      }
      
      if(input1 == 1) {
        
        System.out.println("Do you want to buy stocks or sell stocks? (Enter 'Buy' or 'Sell')");
        String input2 = input.next();
        
        if(input2.equalsIgnoreCase("Buy")) {
					
          PrintStocks();
          System.out.println("Which stock would you like to buy (Enter Number)");
          int stockInput = input.nextInt();
          
          if(stockInput != 1 && stockInput != 2 && stockInput != 3 && stockInput != 4 && stockInput != 5) {
        	  System.out.println("You have entered something wrong. Try again.\n");
        	  menuOptions();
          }
          
            if(stockInput == 1) {
              try {
                System.out.println("How many stocks of AAPL would you like to buy?");
                int quantityInput = input.nextInt();
                double results = AAPLval*quantityInput;
                if(results > MONEY) {
                  System.out.println("You don't have enough money. Try to get more money.");
                  menuOptions();
                }
                else {
            	  MONEY = MONEY - results;
            	  factor = 1;
            	  totalPrice.add(results);
                  stockAAPLval = quantityInput + stockAAPLval;
                  Date date = new Date();
                  transactionNumber += 1;
                  whichStockBoughtArray1.add("AAPL");
                  stockPriceWhenBoughtArray.add(AAPLval); 
                  totalNumOfStocksBoughtArray.add(quantityInput);
                  currentTimeWhenBought.add(date.toString());
                  buyOrsell.add("BUY");
                      Double totalStocksCount = 0.0;
                      totalStocksCount = totalStocksCount + (quantityInput * factor);
                      Double totalPurchasePrice = 0.0;
                      totalPurchasePrice = totalPurchasePrice + (results * factor);
                      WAP = totalPurchasePrice/totalStocksCount;
                      if(WAPcount.size() > 0) {
                    	  WAPcount.add(WAP);
                    	  for(int i = 0; i < WAPcount.size(); i++) {
                    		  if(i > 0) {
                    			  Double WAP1 = WAPcount.get(i);
                    			 WAP1 = (WAPcount.get(i) + WAPcount.get(i-1))/2;
                    			 WAPcount.set(i, WAP1);
                    			 WAP1 = WAP;
                    		  }
                    	  }
                      }
                      else if(WAPcount.size() == 0) {
                    	  WAPcount.add(WAP);
                      }
                  System.out.println("Successfully Bought!");
                  menuOptions();
                }
              }
              catch(InputMismatchException e) {
                System.out.println("You have entered something wrong. Try again.");
                menuOptions();
              }
            }
          
          if(stockInput == 2) {
            try {
              System.out.println("How many stocks of AMZN would you like to buy?");
              int quantityInput = input.nextInt();
              double results = AMZNval*quantityInput;
              if(results > MONEY) {
                System.out.println("You don't have enough money. Try to get more money.");
                menuOptions();
              }
              else {
                MONEY = MONEY - results;
                totalPrice.add(results);
                stockAMZNval = quantityInput + stockAMZNval;
                Date date = new Date();
                transactionNumber += 1;
                whichStockBoughtArray1.add("AMZN");
                stockPriceWhenBoughtArray.add(AMZNval);
                totalNumOfStocksBoughtArray.add(quantityInput);
                currentTimeWhenBought.add(date.toString());
                buyOrsell.add("BUY");
                Double totalStocksCount = 0.0;
                totalStocksCount = totalStocksCount + (quantityInput * factor);
                Double totalPurchasePrice = 0.0;
                totalPurchasePrice = totalPurchasePrice + (results * factor);
                WAP = totalPurchasePrice/totalStocksCount;
                if(WAPcount.size() > 0) {
              	  WAPcount.add(WAP);
              	  for(int i = 0; i < WAPcount.size(); i++) {
              		  if(i > 0) {
              			  Double WAP1 = WAPcount.get(i);
              			 WAP1 = (WAPcount.get(i) + WAPcount.get(i-1))/2;
              			 WAPcount.set(i, WAP1);
              			 WAP1 = WAP;
              		  }
              	  }
                }
                else if(WAPcount.size() == 0) {
              	  WAPcount.add(WAP);
                }
                System.out.println("Successfully Bought!");
                menuOptions();
              }
            }
            catch(InputMismatchException e) {
              System.out.println("You have entered something wrong. Try again.");
            }
          }
          
          if(stockInput == 3) {
            try {
              System.out.println("How many stocks of GBTC would you like to buy?");
              int quantityInput = input.nextInt();
              double results = GBTCval*quantityInput;
              if(results > MONEY) {
                System.out.println("You don't have enough money. Try to get more money.");
                menuOptions();
              }
              else {
                MONEY = MONEY - results;
                totalPrice.add(results);
                stockGBTCval = quantityInput + stockGBTCval;
                Date date = new Date();
                transactionNumber += 1;
                whichStockBoughtArray1.add("GBTC");
                stockPriceWhenBoughtArray.add(GBTCval);
                totalNumOfStocksBoughtArray.add(quantityInput);
                currentTimeWhenBought.add(date.toString());
                buyOrsell.add("BUY");
                Double totalStocksCount = 0.0;
                totalStocksCount = totalStocksCount + (quantityInput * factor);
                Double totalPurchasePrice = 0.0;
                totalPurchasePrice = totalPurchasePrice + (results * factor);
                WAP = totalPurchasePrice/totalStocksCount;
                if(WAPcount.size() > 0) {
              	  WAPcount.add(WAP);
              	  for(int i = 0; i < WAPcount.size(); i++) {
              		  if(i > 0) {
              			  Double WAP1 = WAPcount.get(i);
              			 WAP1 = (WAPcount.get(i) + WAPcount.get(i-1))/2;
              			 WAPcount.set(i, WAP1);
              			WAP1 = WAP;
              		  }
              	  }
                }
                else if(WAPcount.size() == 0) {
              	  WAPcount.add(WAP);
                }
                System.out.println("Successfully Bought!");
                menuOptions();
              }
            }
            catch(InputMismatchException e) {
              System.out.println("You have entered something wrong. Try again.");
            }
          }
          
          if(stockInput == 4) {
            try {
              System.out.println("How many stocks of BABA would you like to buy?");
              int quantityInput = input.nextInt();
              double results = BABAval*quantityInput;
              if(results > MONEY) {
                System.out.println("You don't have enough money. Try to get more money.");
                menuOptions();
              }
              else {
                MONEY = MONEY - results;
                totalPrice.add(results);
                stockBABAval = quantityInput + stockBABAval;
                Date date = new Date();
                transactionNumber += 1;
                whichStockBoughtArray1.add("BABA");
                stockPriceWhenBoughtArray.add(BABAval);
                totalNumOfStocksBoughtArray.add(quantityInput);
                currentTimeWhenBought.add(date.toString());
                buyOrsell.add("BUY");
                Double totalStocksCount = 0.0;
                totalStocksCount = totalStocksCount + (quantityInput * factor);
                Double totalPurchasePrice = 0.0;
                totalPurchasePrice = totalPurchasePrice + (results * factor);
                WAP = totalPurchasePrice/totalStocksCount;
                if(WAPcount.size() > 0) {
              	  WAPcount.add(WAP);
              	  for(int i = 0; i < WAPcount.size(); i++) {
              		  if(i > 0) {
              			  Double WAP1 = WAPcount.get(i);
              			 WAP1 = (WAPcount.get(i) + WAPcount.get(i-1))/2;
              			 WAPcount.set(i, WAP1);
              			WAP1 = WAP;
              		  }
              	  }
                }
                else if(WAPcount.size() == 0) {
              	  WAPcount.add(WAP);
                }
                System.out.println("Successfully Bought!");
                menuOptions();
              }
            }
            catch(InputMismatchException e) {
              System.out.println("You have entered something wrong. Try again.");
            }
          }
          
          if(stockInput == 5) {
            try {
              System.out.println("How many stocks of COST would you like to buy?");
              int quantityInput = input.nextInt();
              double results = COSTval*quantityInput;
              if(results > MONEY) {
                System.out.println("You don't have enough money. Try to get more money.");
                menuOptions();
              }
              else {
                MONEY = MONEY - results;
                totalPrice.add(results);
                stockCOSTval = quantityInput + stockCOSTval;
                Date date = new Date();
                transactionNumber += 1;
                whichStockBoughtArray1.add("COST");
                stockPriceWhenBoughtArray.add(COSTval);
                totalNumOfStocksBoughtArray.add(quantityInput);
                currentTimeWhenBought.add(date.toString());
                buyOrsell.add("BUY");
                Double totalStocksCount = 0.0;
                totalStocksCount = totalStocksCount + (quantityInput * factor);
                Double totalPurchasePrice = 0.0;
                totalPurchasePrice = totalPurchasePrice + (results * factor);
                WAP = totalPurchasePrice/totalStocksCount;
                if(WAPcount.size() > 0) {
              	  WAPcount.add(WAP);
              	  for(int i = 0; i < WAPcount.size(); i++) {
              		  if(i > 0) {
              			  Double WAP1 = WAPcount.get(i);
              			 WAP1 = (WAPcount.get(i) + WAPcount.get(i-1))/2;
              			 WAPcount.set(i, WAP1);
              			WAP1 = WAP;
              		  }
              	  }
                }
                else if(WAPcount.size() == 0) {
              	  WAPcount.add(WAP);
                }
                System.out.println("Successfully Bought!");
                menuOptions();
              }
            }
            catch(InputMismatchException e) {
              System.out.println("You have entered something wrong. Try again.");
            }
          }
          
        }    
        else if(input2.equalsIgnoreCase("Sell")) {
          PrintStocks();
          System.out.println("Which stock would you like to sell (Enter Number)");
          int stockInput = input.nextInt();
          
          if(stockInput != 1 && stockInput != 2 && stockInput != 3 && stockInput != 4 && stockInput != 5) {
        	  System.out.println("You have entered something wrong. Try again.");
        	  menuOptions();
          }
          
            if(stockInput == 1) {
              try {
                System.out.println("How many stocks of AAPL would you like to sell?");
                int quantityInput = input.nextInt();
                double results = AAPLval*quantityInput;
                if(stockAAPLval < quantityInput) {
                  System.out.println("You don't have enough stocks. Try to get more stocks.");
                  menuOptions();
                }
                else {
                  MONEY = MONEY + results;
                  totalPrice.add(results);
                  Date date = new Date();
                  stockAAPLval = stockAAPLval - quantityInput;
                  transactionNumber += 1;
                  whichStockBoughtArray1.add("AAPL");
                  stockPriceWhenBoughtArray.add(AAPLval);
                  totalNumOfStocksBoughtArray.add(quantityInput);
                  currentTimeWhenBought.add(date.toString());
                  buyOrsell.add("SELL");
                  WAPcount.add(WAP);
                  System.out.println("Successfully Sold!");
                  menuOptions();
                }
              }
              catch(InputMismatchException e) {
                System.out.println("You have entered something wrong. Try again.");
                menuOptions();
              }
            }
          
          if(stockInput == 2) {
            try {
              System.out.println("How many stocks of AMZN would you like to sell?");
              int quantityInput = input.nextInt();
              double results = AMZNval*quantityInput;
              if(stockAMZNval < quantityInput) {
                System.out.println("You don't have enough stocks. Try to get more stocks.");
                menuOptions();
              }
              else {
                MONEY = MONEY + results;
                totalPrice.add(results);
                Date date = new Date();
                stockAMZNval = stockAMZNval - quantityInput;
                transactionNumber += 1;
                whichStockBoughtArray1.add("AMZN");
                stockPriceWhenBoughtArray.add(AMZNval);
                totalNumOfStocksBoughtArray.add(quantityInput);
                currentTimeWhenBought.add(date.toString());
                buyOrsell.add("SELL");
                WAPcount.add(WAP);
                System.out.println("Successfully Sold!");
                menuOptions();
              }
            }
            catch(InputMismatchException e) {
              System.out.println("You have entered something wrong. Try again.");
            }
          }
          
          if(stockInput == 3) {
            try {
              System.out.println("How many stocks of GBTC would you like to sell?");
              int quantityInput = input.nextInt();
              double results = GBTCval*quantityInput;
              if(stockGBTCval < quantityInput) {
                System.out.println("You don't have enough stocks. Try to get more stocks.");
                menuOptions();
              }
              else {
                MONEY = MONEY + results;
                totalPrice.add(results);
                Date date = new Date();
                stockGBTCval = stockGBTCval - quantityInput;
                transactionNumber += 1;
                whichStockBoughtArray1.add("GBTC");
                stockPriceWhenBoughtArray.add(GBTCval);
                totalNumOfStocksBoughtArray.add(quantityInput);
                currentTimeWhenBought.add(date.toString());
                buyOrsell.add("SELL");
                WAPcount.add(WAP);
                System.out.println("Successfully Sold!");
                menuOptions();
              }
            }
            catch(InputMismatchException e) {
              System.out.println("You have entered something wrong. Try again.");
            }
          }
          
          if(stockInput == 4) {
            try {
              System.out.println("How many stocks of BABA would you like to sell?");
              int quantityInput = input.nextInt();
              double results = BABAval*quantityInput;
              if(stockBABAval < quantityInput) {
                System.out.println("You don't have enough stocks. Try to get more stocks.");
                menuOptions();
              }
              else {
                MONEY = MONEY + results;
                totalPrice.add(results);
                Date date = new Date();
                stockBABAval = stockBABAval - quantityInput;
                transactionNumber += 1;
                whichStockBoughtArray1.add("BABA");
                stockPriceWhenBoughtArray.add(BABAval);
                totalNumOfStocksBoughtArray.add(quantityInput);
                currentTimeWhenBought.add(date.toString());
                buyOrsell.add("SELL");
                WAPcount.add(WAP);
                System.out.println("Successfully Sold!");
                menuOptions();
              }
            }
            catch(InputMismatchException e) {
              System.out.println("You have entered something wrong. Try again.");
            }
          }
          
          if(stockInput == 5) {
            try {
              System.out.println("How many stocks of COST would you like to sell?");
              int quantityInput = input.nextInt();
              double results = COSTval*quantityInput;
              if(stockCOSTval < quantityInput) {
                System.out.println("You don't have enough stocks. Try to get more stocks.");
                menuOptions();
              }
              else {
                MONEY = MONEY + results;
                totalPrice.add(results);
                Date date = new Date();
                stockCOSTval = stockCOSTval - quantityInput;
                transactionNumber += 1;
                whichStockBoughtArray1.add("COST");
                stockPriceWhenBoughtArray.add(COSTval);
                totalNumOfStocksBoughtArray.add(quantityInput);
                currentTimeWhenBought.add(date.toString());
                buyOrsell.add("SELL");
                WAPcount.add(WAP);
                System.out.println("Successfully Sold!");
                menuOptions();
              }
            }
            catch(InputMismatchException e) {
              System.out.println("You have entered something wrong. Try again.");
              
            }
          }
          
          
        }
        else {
      
          System.out.println("You have entered something wrong. Try again.");
          menuOptions();
          
        }  
      }
      
      if(input1 == 2) {
          History();
          System.out.println("Type 'back' to go back to options menu");
          String inp = input.next();
          if(inp.equalsIgnoreCase("Back")) {
              menuOptions();
          }
          else {
              System.out.println("You have entered something wrong");
              menuOptions();
          }
      }
      else if(input1 == 3) {
    	System.out.println("Successfully exited.");
    	System.exit(0);
      }
      
    }
    
    public static void run1() {
    	
    	Timer timer = new Timer();
  	  	timer.schedule(
		new TimerTask(){
  		          @Override
  		  public void run() {
    	
			double start = 1300;
		    double end = 1600;
		    double random = new Random().nextDouble();
		    double result = start + (random * (end - start));
		    DecimalFormat df = new DecimalFormat("##.##");
		    String dfresult = df.format(result);
		    Double result1 = Double.parseDouble(dfresult);
		    AMZNval = result1;
		    
  		  }
		}, 20000);
        
        
    	
    }
    
    public static void run2() {
    	
    	Timer timer = new Timer();
    	  	timer.schedule(
			new TimerTask(){
    		          @Override
    		  public void run() {
    	
		    	double start = 10;
		        double end = 25;
		        double random = new Random().nextDouble();
		        double result = start + (random * (end - start));
		        DecimalFormat df = new DecimalFormat("##.##");
		        String dfresult = df.format(result);
		        Double result1 = Double.parseDouble(dfresult);
		        GBTCval = result1;
        
    		  }
    		}, 25000);
    	
    }
    
    public static void run3() {
    	
    	Timer timer = new Timer();
	  	timer.schedule(
		new TimerTask(){
		          @Override
		  public void run() {
    	
	    	double start = 100;
	        double end = 250;
	        double random = new Random().nextDouble();
	        double result = start + (random * (end - start));
	        DecimalFormat df = new DecimalFormat("##.##");
	        String dfresult = df.format(result);
	        Double result1 = Double.parseDouble(dfresult);
	        BABAval = result1;
        
		  }
		}, 35000);
    }
    
    public static void run4() {
    	
    	Timer timer = new Timer();
	  	timer.schedule(
		new TimerTask(){
		          @Override
		  public void run() {
    	
	    	double start = 100;
	        double end = 250;
	        double random = new Random().nextDouble();
	        double result = start + (random * (end - start));
	        DecimalFormat df = new DecimalFormat("##.##");
	        String dfresult = df.format(result);
	        Double result1 = Double.parseDouble(dfresult);
	        COSTval = result1;
	        
    	 }
	   }, 2000);
        
    }
    
    
    
    public boolean checkIfNumber(String input, int input1) {
        try {
          Integer.parseInt(input);
        }
        catch(NumberFormatException e)
        {
          return false;
        }
      return true;
    }
    
    private void History() {
      
      System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
      System.out.print("| BUY or SELL | ");
      System.out.print("Stock | ");
      System.out.print("Price When Bought | ");
      System.out.print("Quantity | ");
      System.out.print("Total Price Bought or Sold | ");
      System.out.print("WAP | ");
      System.out.print("       Time When Bought        |");
      System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
      
      for(int i = 0; i < stockPriceWhenBoughtArray.size() && i < whichStockBoughtArray1.size() && i < totalNumOfStocksBoughtArray.size() && i < buyOrsell.size() && i < currentTimeWhenBought.size() && i < totalPrice.size() && i < WAPcount.size(); i++) {
    	  System.out.print("|    " + buyOrsell.get(i) + "    | ");
    	  System.out.print(" " + whichStockBoughtArray1.get(i) + " | ");
    	  System.out.print("       " + "$" + stockPriceWhenBoughtArray.get(i) + "       | ");
    	  System.out.print("   " + totalNumOfStocksBoughtArray.get(i) + "   | ");
    	  System.out.print("          " + "$" + Math.round(totalPrice.get(i) * 100.000) / 100.000 + "          | ");
    	  System.out.print("$" + Math.round(WAPcount.get(i) * 100.000) / 100.000 + " | ");
    	  System.out.print(" " + currentTimeWhenBought.get(i) + " |");
    	  System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
      } 
        
    }
    
    private double unrealizedProfitLoss(int currqty, double WAP, int stockval) {
    	double unprofitloss = (currqty*stockval)-(currqty*WAP);
    	return unprofitloss;
    }
    
    protected static void PrintStocks() {  
        System.out.println("____________________________");
        System.out.println("(1) AAPL Stock Value: " + AAPLval + " |");
        System.out.println("----------------------------");
        System.out.println("(2) AMZN Stock Value: " + AMZNval + " |");
        System.out.println("----------------------------");
        System.out.println("(3) GBTC Stock Value: " + GBTCval + " |");
        System.out.println("----------------------------");
        System.out.println("(4) BABA Stock Value: " + BABAval + " |");
        System.out.println("----------------------------");
        System.out.println("(5) COST Stock Value: " + COSTval + " |");
        System.out.println("----------------------------");
    }
		
  }
