package com.leedsdebatingunion

import scala.math

object MetricalList { 
  def normalizePercentage(x: Double, max: Double): Double = 100*(x/max)
  
  def even(z: Int): Boolean = 
    z % 2 == 0
  
  def odd(z :Int) : Boolean = 
    !even(z)
  
  def rescale(x: Double, min: Double, max: Double) = 
    (if(x > max) max else if(x < min) min else x) * (100/max)
    
  def round(x: Double, precision: Int = 1): Double = math.round(x * math.pow(10,precision))/math.pow(10,precision)
}

class MetricalList(val data: List[Double]) {
  def median(): Double = {
    val len   = data.length
    val left  = (0.5 * (data.length - 1)).toInt
    val right = (0.5 * data.length).toInt
    
    if(MetricalList.even(len)) 
      0.5 * (data(left) + data(right))
    else 
      data(left + 1)
  }
 
  def stdev(): Double = {
    val N = data.length
    val sumSq: Double = (for(x <- data) yield x * x).sum
    val sum   = data.sum

    math.sqrt((sumSq/N) - (sum * sum)/(N*N))
  }
  
  def average = data.sum / data.length 
}

