import java.util.ArrayList;

public class PrimeNumberGenerator {

int start;

PrimeNumberGenerator(int start)
{
this.start = start;
prime.add(2);
}
public ArrayList<Integer> prime = new ArrayList<>();
static int pointer=-1;

void simpleSieve(int limit)
{
boolean mark[] = new boolean[limit];
int num[] = new int[limit];
int k;
for(Integer p : prime) {
k=(int)Math.ceil(limit/p.doubleValue());
for(int i=k;i*p<limit*2;i+=1)
mark[i*p-limit]=true;
}
for(int i=0;i<limit;++i)
{
num[i]=limit+i;
if(!mark[i]) {
prime.add(num[i]);
for(int j=2*num[i];j<limit;j+=num[i])
mark[j-limit]=true;
}
}
}

int GetNextPrime()
{
while(pointer<0) {
simpleSieve(prime.get(prime.size()-1)+1);
for(Integer p:prime) {
if (p.intValue()>=start) {
pointer=prime.indexOf(p);
break;
}
}
}
if(pointer==prime.size()-1) {
simpleSieve(prime.get(prime.size()-1)+1);
}
pointer++;
return prime.get(pointer-1);
}

}