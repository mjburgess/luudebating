package com.leedsdebatingunion

case class CompetitorStub(tabMedian: Double, trialAverage: Double, consistency: Double, service: Int, reputation: Int) {  
  def goodness: Double 		=	(2 * service + reputation)/3
  def rank: Double 			=	(3 * merit + goodness)/4
  
  def merit: Double = MetricalList.normalizePercentage(
		  3 * tabMedian + 2 * trialAverage + consistency, 
      300 + 200 + 100)
  
  def desc = 
    Map((math round tabMedian, math round trialAverage,  MetricalList.round(consistency,2), service, reputation) -> (math.round(rank), math.round(merit), math.round(goodness)))

  override def toString = 
    "\n(tM, tA, C) -> (r, g, m) = \t" + desc.toString	
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
  
  
  
  def desc = 
    Map((math round tabMedian, math round trialAverage, MetricalList.round(consistency,2), service, reputation) -> (math.round(rank), math.round(merit), math.round(goodness)))

  override def toString = 
    "\n(tM, tA, C) -> (r, g, m) = \t" + desc.toString
}

object Competitor {
  def apply(tabMedian: Double, trialAverage: Double, consistency: Double, service: Int, reputation: Int) =
    new CompetitorStub(tabMedian, trialAverage, consistency, service, reputation)
}