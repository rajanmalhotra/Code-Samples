package com.rajan.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Box Stacking. You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i), 
 * width w(i) and depth d(i) (all real numbers). You want to create a stack of boxes which is as tall as possible,
 * but you can only stack a box on top of another box if the dimensions of the 2-D base of the lower box are 
 * each strictly larger than those of the 2-D base of the higher box. Of course, you can rotate a box so that 
 * any side functions as its base. It is also allowable to use multiple instances of the same type of box. 
 *
 * Solution : similar to Longest Increasing SubSequence
 */

class Box{
	int height;
	int width;
	int depth;
	
	public Box(int h, int w, int d){
		height = h;
		width = w;
		depth = d;
	}
}

class BoxComparator implements Comparator<Box>{
	public int compare(Box a, Box b){
		int areaA = a.width * a.depth;
		int areaB = b.width * b.depth;
		if(areaA > areaB){
			return -1;
		}else if(areaA == areaB){
			return 0;
		}else{
			return 1;
		}
	}
}

public class BoxStacker {

	public static int stackBoxes(Box[] boxes){
		Box allBoxes[] = new Box[boxes.length*3];
		for(int i=0; i<boxes.length; i++){
			/*
			allBoxes[6*i] = new Box(boxes[i].height, boxes[i].width, boxes[i].depth);
			allBoxes[6*i+1] = new Box(boxes[i].width, boxes[i].depth, boxes[i].height);
			allBoxes[6*i+2] = new Box(boxes[i].depth, boxes[i].height, boxes[i].width);
			allBoxes[6*i+3] = new Box(boxes[i].height, boxes[i].depth, boxes[i].width);
			allBoxes[6*i+4] = new Box(boxes[i].width, boxes[i].height, boxes[i].depth);
			allBoxes[6*i+5] = new Box(boxes[i].depth, boxes[i].width, boxes[i].height);*/
			
			if(boxes[i].width < boxes[i].depth){
				allBoxes[3*i] = new Box(boxes[i].height, boxes[i].width, boxes[i].depth);
			}else{
				allBoxes[3*i] = new Box(boxes[i].height, boxes[i].depth, boxes[i].width);
			}
			if(boxes[i].depth < boxes[i].height){
				allBoxes[3*i+1] = new Box(boxes[i].width, boxes[i].depth, boxes[i].height);
			}else{
				allBoxes[3*i+1] = new Box(boxes[i].width, boxes[i].height, boxes[i].depth);
			}
			if(boxes[i].height < boxes[i].width){
				allBoxes[3*i+2] = new Box(boxes[i].depth, boxes[i].height, boxes[i].width);
			}else{
				allBoxes[3*i+2] = new Box(boxes[i].depth, boxes[i].width, boxes[i].height);
			}
		}
		Arrays.sort(allBoxes, new BoxComparator());
		for(Box b:allBoxes){
			System.out.println(b.width*b.depth);
		}
		System.out.println();
		int height=0;
		int Heights[] = new int[allBoxes.length];
		for(int i=0; i < Heights.length; i++){
			Heights[i] = 0;
		}
		
		for(int i=1; i < allBoxes.length; i++){
			for(int j=0; j<i; j++){
				if(allBoxes[j].width > allBoxes[i].width && allBoxes[j].depth > allBoxes[i].depth){
					height = Heights[j] + allBoxes[i].height;
				}
				if(height > Heights[i]){
					Heights[i] = height;
				}
			}
		}
		int max=0;
		for(int i=0; i < Heights.length; i++){
			if(max < Heights[i]){
				max = Heights[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		Box[] boxes = { new Box(3, 2, 1),
						new Box(5, 4, 2),
						new Box(3, 5, 6),
						new Box(3, 7, 7),
						new Box(4, 8, 9)
						};
		System.out.println("Height of Stack of Boxes : " + stackBoxes(boxes));
	}
}
