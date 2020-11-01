import java.util.*;

public class Main
{
        public static void main(String[]args)
        {
            Scanner scan = new Scanner(System.in);
            int n = Integer.parseInt(scan.nextLine());
            String stringArray[] = new String[n];

            for(int i=0;i<n;i++)
            {
                stringArray[i] = scan.nextLine();
            }

            recQuickSort(stringArray);

            for(int i=0;i<n;i++)
            {
                System.out.println(stringArray[i]);
            }
        }

        public static void recQuickSort(String stringArray[])
        {
            recQuickSort(stringArray, 0, stringArray.length-1);
        }

         public static void recQuickSort(String stringArray[], int left, int right)
         {
            if(left >= right)
            {
                return;
            }

            int pivot = right;
            int j = right-1;
            int i = left;

            while(i < pivot && j >= 0)
            {
                if(i == j)
                {
                    if(compare(stringArray[i], stringArray[pivot]))
                    {
                        swap(stringArray, i, pivot);
                    }
                    break;
                }

                if(i > j)
                {
                    swap(stringArray, i, pivot);
                    break;
                }

                if(compare(stringArray[i], stringArray[pivot]) && !compare(stringArray[j], stringArray[pivot]))
                {
                    swap(stringArray, i, j);
                    i++;
                    j--;
                }

                else if(compare(stringArray[i], stringArray[pivot]))
                {
                    j--;
                }

                else if(!compare(stringArray[j], stringArray[pivot]))
                {
                    i++;
                }

                else
                {
                    i++;
                    j--;
                }
            }
            recQuickSort(stringArray, left, j);
            recQuickSort(stringArray, i+1, right);
        }

            public static boolean compare(String left, String right)
            {
                char c1[] = left.toCharArray();
                char c2[] = right.toCharArray();

                Arrays.sort(c1);
                Arrays.sort(c2);

                if(c1[c1.length-1] > c2[c2.length-1])
                {
                    return true;
                }

                else if(c1[c1.length-1] < c2[c2.length-1])
                {
                    return false;
                }

                else
                {
                    if(left.compareTo(right) > 0)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }

            public static void swap(String stringArray[], int i, int j)
            {
                String temp = stringArray[i];
                stringArray[i] = stringArray[j];
                stringArray[j] = temp;
            }
        }