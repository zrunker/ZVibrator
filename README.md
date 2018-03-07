# ZVibrator
Android当中Vibrator振动器的简单使用
>作者：邹峰立，微博：zrunker，邮箱：zrunker@yahoo.com，微信公众号：书客创作，个人平台：[www.ibooker.cc](http://www.ibooker.cc)。

>本文选自[书客创作](http://www.ibooker.cc)平台第48篇文章。[阅读原文](http://www.ibooker.cc/article/48/detail) 。

![书客创作](http://upload-images.jianshu.io/upload_images/3480018-7709d612e8e36dc6..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

Android开启振动主要运用了Vibrator（振动器），系统中有一个Vibrator抽象类，可以通过获取Vibrator实例调用里面的方法来完成振动功能。

初始化：
```
Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
```
启动振动，还需要在清单文件AndroidManifest.xml中添加权限
```
<uses-permission android:name="android.permission.VIBRATE"/>
```
常用方法：
```
vibrator.vibrate(1000);  // 设置手机振动
vibrator.hasVibrator();  // 判断手机硬件是否有振动器
vibrator.cancel();// 关闭振动
```

注：在Android新版本API当中vibrate方法有所变动。

旧版本常用方法介绍：
```
/*
 * 立即振动
 * @param milliseconds 振动持续时间
 */
vibrate(long milliseconds);

/*
 * 立即振动
 * @param milliseconds 振动持续时间
 * @param attributes 振动属性
 */
vibrate(long milliseconds, AudioAttributes attributes);

/*
 * 波形振动
 * @param pattern 数组中的整数用来打开或关闭振动器，第一个值表示在打开振动器之前要等待的毫秒数下一个值表示在关闭振动器之前保持振动器的毫秒数，随后的值交替执行。
 * @param repeat 振动重复的模式
 */
vibrate(long[] pattern, int repeat);

/*
 * 波形振动
 * @param pattern 数组中的整数用来打开或关闭振动器，第一个值表示在打开振动器之前要等待的毫秒数下一个值表示在关闭振动器之前保持振动器的毫秒数，随后的值交替执行。
 * @param repeat 振动重复的模式
 * @param attributes 振动属性
 */
vibrate(long[] pattern, int repeat, AudioAttributes attributes);
```
新版本常用方法介绍：

首先理解VibrationEffect类的用法：
```
/**
 * 创建一次性振动
 *
 * @param milliseconds 震动时长（ms）
 * @param amplitude 振动强度。这必须是1到255之间的值，或者DEFAULT_AMPLITUDE
 */
VibrationEffect vibrationEffect = VibrationEffect.createOneShot(long milliseconds, int amplitude);

/**
 * 创建波形振动
 *
 * @param timings 交替开关定时的模式，从关闭开始。0的定时值将导致定时/振幅对被忽略。
 * @param repeat 振动重复的模式，如果您不想重复，则将索引放入计时数组中重复，或者-1。
 *               -1 为不重复
 *               0 为一直重复振动
 *               1 则是指从数组中下标为1的地方开始重复振动，重复振动之后结束
 *               2 从数组中下标为2的地方开始重复振动，重复振动之后结束
 */
VibrationEffect vibrationEffect = VibrationEffect.createWaveform(long[] timings, int repeat);

/**
 * 创建波形振动
 *
 * @param timings 振幅值中的定时值。定时值为0振幅可忽视的。
 * @param amplitudes 振幅值中的振幅值。振幅值必须为0和255之间，或为DEFAULT_AMPLITUDE。振幅值为0意味着断开。
 * @param repeat 振动重复的模式，如果您不想重复，则将索引放入计时数组中重复，或者-1。
 */
VibrationEffect vibrationEffect = VibrationEffect.createWaveform(long[] timings, int[] amplitudes, int repeat);
```
vibrate方法的使用：
```
/**
 * 启动振动
 *
 * @param vibe 可以理解为震动的规则
 */
vibrate(VibrationEffect vibe);

/**
 * 启动振动
 *
 * @param vibe 可以理解为震动的规则
 * @param attributes 振动属性，如闹钟振动，来电振动等
 */
vibrate(VibrationEffect vibe, AudioAttributes attributes);
```

[Github地址](https://github.com/zrunker/ZVibrator)
[阅读原文](http://www.ibooker.cc/article/48/detail)

----------
![微信公众号：书客创作](http://upload-images.jianshu.io/upload_images/3480018-50c530d89f70eb26..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
