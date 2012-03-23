package com.leedsdebatingunion

case class CompetitorStub(tabMedian: Double, trialAverage: Double, consistency: Double, service: Int, reputation: Int) {  
  def goodness: Double 		=	(2 * service + reputation)/3
  def rank: Double 			=	(5 * merit + goodness)/6
  
  def merit: Double = 8.75 + MetricalList.normalizePercentage((3 + 2*tabMedian/100) * tabMedian + (1 + 2.20*trialAverage/100) * trialAverage + 0.8*consistency, 500 + 320 + 80)
}













case class Competitor(ivSpeaks: List[Double], trialSpeaks: List[Double], service: Int, reputation: Int) {
  def tabMedian: Double 	= 	ivSpeaks.median 
  def trialAverage: Double 	= 	trialSpeaks.average
}

object Competitor {
  def apply(tabMedian: Double, trialAverage: Double, consistency: Double, service: Int, reputation: Int) =
    new CompetitorStub(tabMedian, trialAverage, consistency, service, reputation)
}