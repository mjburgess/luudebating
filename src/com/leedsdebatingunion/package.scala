package com

package object leedsdebatingunion {
	implicit def listToMertical(l: List[Double]): MetricalList = new MetricalList(l)
}