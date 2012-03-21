package com.leedsdebatingunion

object Eudc {
  def example(): List[CompetitorStub] = {
	  (for(x <- 70 to 80; y <- 0.4 to 5 by 0.2) 
	    yield Competitor(x, (x + y).toInt.toDouble, 100, 80, 70)
	  ).toList
  }	
}