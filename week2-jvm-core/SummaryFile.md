# Week2 题目4

## 有关GC和堆内存的总结

1. 从 128m到256m 由于对大小小于创建对象占用的大小，导致oom. 因此内存越小不管是Young GC 和 Full gc次数会频繁触发，导致大量时间在做gc；
2. 同等内存大小情况下 串行gc 时间 几乎是 并行gc的1.5倍；
3. 内存越大的情况下 G1 回收的效率越高，gc时间比其他回收器时间短、内存越大g1效果越好；
4. 可以看到内存越大的情况下g1的垃圾回收基本优于串行 并行 以及 cms 不管是从吞吐量和gc时间来说；
5. cms吞吐量相对于其他回收器明显存在劣势，平均回收时间波动较大；
