	public void flipLetter(int index, Status newStatus) {
		
		/*
		 * FIX CODE
		 * The following part of this code will freeze the program when run
		 * Please turn this into a separate thread instead
		 */
		
//		LetterBox lb = letterBox[index];
//		
//		try {
//		for(double i=21;i>0;i--) {
//			letterScale[index] = i/20;
//			
//			updateCanvas(); //CAUTION: This method contains UI update, which can cause an error if running in a different thread
//			
//			Thread.sleep(16);
//		}
//		
//		lb.setStatus(newStatus);
//		
//		for(double i=0;i<21;i++) {
//			letterScale[index] = i/20;
//			
//			updateCanvas(); //CAUTION: This method contains UI update, which can cause an error if running in a different thread
//			
//			Thread.sleep(16);
//		}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}


		LetterBox lb = letterBox[index];
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				updateCanvas(); //CAUTION: This method contains UI update, which can cause an error if running in a different thread
			}
		};
		
		Thread t = new Thread(()-> {
			try {
				for(double i=21;i>0;i--) {
					letterScale[index] = i/20;
					
					//updateCanvas(); //CAUTION: This method contains UI update, which can cause an error if running in a different thread
					
					Platform.runLater(r);
					
					Thread.sleep(16);
				}
				
				lb.setStatus(newStatus);
				
				for(double i=0;i<21;i++) {
					letterScale[index] = i/20;
					
					//updateCanvas(); //CAUTION: This method contains UI update, which can cause an error if running in a different thread
					
					Platform.runLater(r);
					
					Thread.sleep(16);
				}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		});
			
		t.start();

		
	}
