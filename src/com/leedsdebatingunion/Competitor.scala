package com.leedsdebatingunion

case class CompetitorStub(tabMedian: Double, trialAverage: Double, consistency: Double, service: Int, reputation: Int) {  
  def goodness: Double 		=	(2 * service + reputation)/3
  def rank: Double 			=	(3 * merit + goodness)/4
  
  def merit: Double = MetricalList.normalizePercentage(
		  (3 + 2*tabMedian/100) * tabMedian + (1 + 2.20*trialAverage/100) * trialAverage + 0.8*consistency, 
      500 + 320 + 80)
  
  override def toString = "%.2f\t%.2f\t%.2f\t%d\t%d\t%.2f\n".format(MetricalList.round(tabMedian, 2), MetricalList.round(trialAverage,2), MetricalList.round(consistency,2), service, reputation, rank)	
}













case class Competitor(ivSpeaks: List[Double], trialSpeaks: List[Double], service: Int, reputation: Int) {
  
  def tabMedian: Double 	= 	ivSpeaks.median
  
  def trialAverage: Double 	= 	trialSpeaks.average
  
  def consistency: Double 	=  	100 - MetricalList.rescale((trialSpeaks ::: ivSpeaks).stdev, 0.5, 10)
  
  def goodness: Double 		=	(2 * service + reputation)/3
  
  def rank: Double 			=	(3 * merit + goodness)/4
  
  def merit: Double = 
    100 * (	tabMedian * tabMedian * tabMedian + 
    		trialAverage * trialAverage   	  + 
    		consistency
    	  ) / (1E6 + 1E4 + 1E2)
  
  override def toString = "%.2f\t%.2f\t%.2f\t%d\t%d\t%.2f\n".format(MetricalList.round(tabMedian, 2), MetricalList.round(trialAverage,2), MetricalList.round(consistency,2), service, reputation, rank) 
    
}

object Competitor {
  def apply(tabMedian: Double, trialAverage: Double, consistency: Double, service: Int, reputation: Int) =
    new CompetitorStub(tabMedian, trialAverage, consistency, service, reputation)
}