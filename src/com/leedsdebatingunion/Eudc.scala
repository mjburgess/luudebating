package com.leedsdebatingunion

object Eudc {
  def example(): List[CompetitorStub] = {
	  (for(x <- 60 to 90; y <- 60 to 90) 
	    yield Competitor(75, 75, 100, x, y)
	  ).toList
  }	
  
}