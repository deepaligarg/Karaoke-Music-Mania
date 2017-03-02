package com.example.mayank.mayyuu;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Mayank on 5/9/2016.
 */
public class play_record extends AppCompatActivity {

    Button play, stop, record, result,playorg,stoporg;
    private MediaRecorder myAudioRecorder;
    private String outputFile = null;
    private String playorgfile = null;
    public int pos ;
    public double dee;
    BackgroundSound bs = new BackgroundSound();


    private TextView timerValue;
    private long startTime = 0L;

    private Handler customHandler = new Handler();

    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        String s = getIntent().getStringExtra("Name");

        TextView tv = (TextView) findViewById(com.example.mayank.mayyuu.R.id.song1);
        tv.setText(s);
        int res = getIntent().getExtras().getInt("r1Int");

        ImageView view = (ImageView) findViewById(R.id.image1);

        view.setImageResource(res);

        timerValue = (TextView) findViewById(R.id.timerValue);

        play = (Button) findViewById(R.id.button7);
        stop = (Button) findViewById(R.id.button2);
        record = (Button) findViewById(R.id.button);
        result = (Button) findViewById(R.id.button4);
        playorg = (Button)findViewById(R.id.button123);
        stoporg = (Button)findViewById(R.id.button456);

        stop.setEnabled(false);
        play.setEnabled(false);
        //set
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";
        playorgfile = Environment.getExternalStorageDirectory().getAbsolutePath();
        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);

        pos = getIntent().getExtras().getInt("pos");

        final MediaPlayer mm = new MediaPlayer();
        /*test t = new test();
        t.execute(pos);
        */
        new org().execute(pos);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    bs.execute(pos);
                    startTime = SystemClock.uptimeMillis();
                    customHandler.postDelayed(updateTimerThread, 0);

                    myAudioRecorder.prepare();
                    myAudioRecorder.start();


                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                record.setEnabled(false);
                stop.setEnabled(true);

                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               bs.cancel(true);

                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);

                myAudioRecorder.stop();
                myAudioRecorder.release();
                new recordingg().execute();
                myAudioRecorder = null;

                stop.setEnabled(false);
                play.setEnabled(true);



                Toast.makeText(getApplicationContext(), "Audio recorded successfully", Toast.LENGTH_LONG).show();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException, SecurityException, IllegalStateException {
                MediaPlayer m = new MediaPlayer();
                //TextView t1 = (TextView) findViewById(R.id.textView3);

                try {
                    m.setDataSource(outputFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    m.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                m.start();
                Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
                //t1.setText(outputFile);
                final Context context = v.getContext();
                int bytesRead;


            }
        });

        playorg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException, SecurityException, IllegalStateException {

                //TextView t1 = (TextView) findViewById(R.id.textView3);

                Log.e("pos.........",pos+".......... ");

                try {

                    String fname = "";
                    if(pos==0) {
                        fname = "jannat.mp3";
                    }
                    if(pos==1) {
                        fname = "baby.mp3";
                    }
                    if(pos==2) {
                        fname = "samjhawan.mp3";
                    }
                    if(pos==3) {
                        fname = "tum mile.mp3";
                    }
                    if(pos==4) {
                        fname = "saibo.mp3";
                    }
                    if(pos==5) {
                        fname = "one dir.mp3";
                    }
                    if(pos==6) {
                        fname = "taylor.mp3";
                    }
                    if(pos==7) {
                        fname = "love me.mp3";
                    }
                    if(pos==8) {
                        fname = "bruno mars.mp3";
                    }
                    if(pos==9) {
                        fname = "emptiness.mp3";
                    }

                    playorgfile = playorgfile + "/" + fname;

                    mm.setDataSource(playorgfile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    mm.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mm.start();
                Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
                //t1.setText(outputFile);
                final Context context = v.getContext();
                int bytesRead;


            }
        });

        stoporg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mm.stop();


                Toast.makeText(getApplicationContext(), "Original Song played successfully", Toast.LENGTH_LONG).show();
            }
        });


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException, SecurityException, IllegalStateException {
                //TextView t2 = (TextView) findViewById(R.id.textView4);
                //t2.setText(outputFile);
                final Context context = v.getContext();
                Log.e("the value of deeee",FFT.dee+" ");
                int i = (int)FFT.dee + 50;
                String s = String.valueOf(i)+"%";
                Intent intent12 = new Intent("com.example.mayank.mayyuu.endpage");
                intent12.putExtra("Name1",s);
                startActivity(intent12);


            }

        });



    }

    /*public void OnClickButtonListner() {
        result = (Button) findViewById(R.id.button4);
        result.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                Intent intent12 = new Intent("com.example.mayank.mayyuu.endpage");
                intent12.putExtra("Name1", FFT.dee);
                startActivity(intent12);
            }
        });
    }*/





    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;

            int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("" + mins + ":"

                    + String.format("%02d", secs) + ":"

                    + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);

        }



    };

}




 class FFT{
public static double dee;
    // compute the FFT of x[], assuming its length is a power of 2
    public Complex[] fft(Complex[] x)
    {
        int N = x.length;

        // base case
        if (N == 1) return new Complex[] { x[0] };

        // radix 2 Cooley-Tukey FFT
        if (N % 2 != 0) { throw new RuntimeException("N is not a power of 2"); }

        // fft of even terms
        Complex[] even = new Complex[N/2];
        for (int k = 0; k < N/2; k++) {
            even[k] = x[2*k];
        }
        Complex[] q = fft(even);

        // fft of odd terms
        Complex[] odd  = even;  // reuse the array
        for (int k = 0; k < N/2; k++) {
            odd[k] = x[2*k + 1];
        }
        Complex[] r = fft(odd);

        // combine
        Complex[] y = new Complex[N];
        for (int k = 0; k < N/2; k++)
        {
            double kth = -2 * k * Math.PI / N;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k]       = q[k].plus(wk.times(r[k]));
            y[k + N/2] = q[k].minus(wk.times(r[k]));
        }
        return y;
    }

    // display an array of Complex numbers to standard output
    public void show(Complex[][] x,int sample,int chunksize)
    {
        //System.out.println(title);

        int count = 0;
        Log.e("it is inside the show", "show");
        for (int i = 0; i < sample; i++)
        {
            for(int j=0;j<chunksize;j++)
            {
                System.out.print("    ");
                System.out.print(x[i][j]);
                //Log.e("f",x[i][j]+" ");
                count++;
            }
            System.out.println();
        }
        Log.e("the val of count",count+" ");
    }

    public int power(int a,int b)
    {
        int rem=0;
        return rem;
    }
    public void show1(double[][] x2, double[][] y2, int sample, int chunksize)
    {
        //System.out.println(title);
        System.out.println("-------------------");
        for (int i = 0; i < sample; i++)
        {
            for(int j=0;j<chunksize;j++)
            {
                System.out.print("    ");
                System.out.print(x2[i][j]);
            }
            System.out.println();
        }

        System.out.println("-------------------");
        for (int i = 0; i < sample; i++)
        {
            for(int j=0;j<chunksize;j++)
            {
                System.out.print("    ");
                System.out.print(y2[i][j]);
            }
            System.out.println();
        }

          /* System.out.println("-------------------");
        for (int i = 0; i < sample; i++)
        {
            for(int j=0;j<chunksize;j++)
            {
                System.out.print("    ");
            System.out.print(z2[i][j]);
            }
           System.out.println();
        }*/
        dev(x2,y2,sample,chunksize);
    }

    void dev(double[][]x1,double[][]y1,int sample,int chunksize) {
        //int pos1 = 0,pos11=0,pos2=0,pos22=0;
        double max1, secmax1, max2, secmax2, sum1 = 0, sum2 = 0;
        double[] diffx = new double[sample];
        double[] diffy = new double[sample];
        // double[] diffz=new double[sample];
        // double[] x11=new double[sample];
        // System.out.println("kljlkjl");
        double[] xx = new double[sample];
        double[] yy = new double[sample];
        double[] sc = new double[sample];
        for (int a = 0; a < sample; a++) {
            // System.out.println("k");

            max1 = max2 = x1[a][0];
            secmax2 = secmax1 = 0;


            for (int b = 0; b < chunksize; b++) {

                if (x1[a][b] > max1)

                    max1 = x1[a][b];

                if (y1[a][b] > max2)

                    max2 = x1[a][b];

              /* if(z1[a][b]>max3)

                   max3=z1[a][b];*/
            }
            for (int b = 0; b < chunksize; b++) {
                //  System.out.println("kljll");
                if (x1[a][b] > secmax1 && x1[a][b] < max1)
                    secmax1 = x1[a][b];

                if (y1[a][b] > secmax2 && y1[a][b] < max2)
                    secmax2 = y1[a][b];

                 /*if(z1[a][b]>secmax3 && z1[a][b]<max3)
                   secmax3=z1[a][b];*/

            }

            System.out.println(diffx[a] = max1 - secmax1);

            System.out.print("   ");

            System.out.print(diffy[a] = max2 - secmax2);

            System.out.println("   ");

       /*   System.out.println(diffz[a]=max3-secmax3);

        System.out.print("   ");*/


        }
        System.out.println("------------------");
        for (int g = 0; g < sample; g++) {

            xx[g] = Math.abs(diffx[g] - diffy[g]);
            // sum1=sum1+xx[g];
            System.out.print(xx[g]);
            System.out.print("   ");


       /* yy[g]=Math.abs(diffx[g]-diffz[g]);
        sum2=sum2+yy[g];
        System.out.print(yy[g]);
        System.out.println();*/



        /* System.out.println("for audio1: "+sum1);
         System.out.println("for audio2: "+sum2);
        */
            if(diffx[g]==0)
                continue;

            sc[g] = (xx[g] / diffx[g]) * 100;
            System.out.println(sc[g] + "%");


            sum1 = sum1 + sc[g];
        }
         dee = sum1 / (sample);
        System.out.println(dee + "%");
        dee = (Math.ceil(dee/100)-(dee/100))*100;
        System.out.println("%correctness: " + dee + "%");

    }



     void score(Complex [][]x,Complex[][]y,int sample,int chunksize)
    {
        Complex c=new Complex(1,1);

        double x1[][]=new double[sample][chunksize];
        double y1[][]=new double[sample][chunksize];
        //double z1[][]=new double[sample][chunksize];
        for(int p=0;p<sample;p++)
        {
            for(int q=0;q<chunksize;q++)
            {
                x1[p][q]=c.mod(x[p][q]);
                y1[p][q]=c.mod(y[p][q]);
                //    z1[p][q]=c.mod(z[p][q]);


            }
        }
        show1(x1,y1,sample,chunksize);
    }


    public void receive(int[] recorded,int r, int[] orgnl, int o) {


        int sample;
        int chunksize=16;
        sample=o/chunksize;

        //check the length as power of 2.Also M&N be same

        Log.e("the val of recorded ",r+" ");
        int w = 8;
        while(Math.pow(2,w)<o)
        {
            w++;
        }
        Log.e("the val of w", w + " ");
        int ll = o;
        for(int si=(ll+1);si<Math.pow(2,w);si++)
        {
            orgnl[si] = 0;
            recorded[si] = 0;
            r++;
            o++;
        }
       // Log.e("the val of recorded", r + " ");
        Complex[][] x = new Complex[sample][];
        Complex[][] y = new Complex[sample][];
        // original data
        for(int j=0;j<sample;j++)
        {
            Complex[] complexArr = new Complex[chunksize];
            Complex[] complexArr2 = new Complex[chunksize];
            for (int i = 0; i < chunksize; i++)
            {
                complexArr[i] = new Complex(orgnl[(j*chunksize)+i], 0);
               // complexArr[i] = new Complex(-2*Math.random() + 1, 0);

                complexArr2[i] = new Complex(recorded[(j*chunksize)+i], 0);
                //complexArr2[i] = new Complex(-2*Math.random() + 1, 0);
            }
            Log.e("outside","for");
            x[j]=fft(complexArr);
            y[j]=fft(complexArr2);
        }


        show(x, sample, chunksize);

        show(y, sample, chunksize);

        score(x,y,sample,chunksize);


    }

}

class Complex {
    private final double re;   // the real part
    private final double im;   // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // return a string representation of the invoking Complex object
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // return a new Complex object whose value is (this + b)
    public Complex plus(Complex b) {
        Complex a = this;             // invoking object
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    // return a new Complex object whose value is (this - b)
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // return a new Complex object whose value is (this * b)
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    // scalar multiplication
    // return a new object whose value is (this * alpha)
    public Complex times(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }


    // return a new Complex object whose value is the reciprocal of this
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }

    // return the real or imaginary part
    public double re() { return re; }
    public double im() { return im; }

    // return a / b
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // return a new Complex object whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // return a new Complex object whose value is the complex sine of this
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex cosine of this
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex tangent of this
    public Complex tan() {
        return sin().divides(cos());
    }



    // a static version of plus
    public static Complex plus(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }

    public double mod(Complex b) {
        double real = b.re* b.re;
        double imag = b.im*b.im;
        double val= (int) Math.sqrt(real+imag);
        return val;
    }
}



class org extends AsyncTask<Integer, Void, Void> {

    static public int[] clr = new int[Integer.MAX_VALUE/10000];
    static public int[] bytes = new int[Integer.MAX_VALUE / 1000];
    static public int k = 0;
    protected Void doInBackground(Integer... params) {


        int count = 0;
        Integer pos = params[0];



        try {

            String fileName = "maysmjh.3gp";
            String path = "";
            path = Environment.getExternalStorageDirectory() + "/" + fileName;

            File file = new File(path);
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(file);

            int i = 0;

            int j = 0;
            int prvsi = 0;
            count = 0;
            while ((i = fileInputStream.read()) != -1) {

                //if (Math.abs(i - prvsi) >= 40) {


                    //Log.e("before prvsi", prvsi + " ");
                    if (i >= 128) {
                        bytes[k] = (-128) + (i % 128);

                        Log.e("the value of i in lo", i + " ");
                        Log.e("byte array value.... ", bytes[k] + " ");
                        k++;
                    } else {
                        bytes[k] = i;

                        Log.e("the value of i in lo", i + " ");
                        Log.e("byte array value.... ", bytes[k] + " ");
                        k++;
                    }
                    //prvsi = i;
                    Log.e("val of i", i + " ");
                    //Log.e("after prvsi", prvsi + " ");
                //}
                /*else
                {
                    clr[j] = count;
                    j++;
                }*/
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("the val of count", count + " ");
        Log.e("the val of k", k + " ");



        return null;

    }

    protected  void onPostExecute(){
        Log.e("the post","post execution");
    }
}


class recordingg extends AsyncTask<Void, Void, Void>{


    org or = new org();
    protected Void doInBackground(Void... Params)
    {
        int kk = 0;
        int countt = 0;
        int[] bytess = new int[Integer.MAX_VALUE / 1000];
        try {
            String fileName = "recording.3gp";
            String path = "";
            path = Environment.getExternalStorageDirectory() + "/" + fileName;

            File file = new File(path);
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(file);

            int ii = 0;
            kk = 0;

            countt = 0;
            int j=0;
            while ((ii = fileInputStream.read()) != -1) {

                /*if(countt == or.clr[j])
                {

                    j++;
                    countt++;
                    continue;

                }*/
                //else
                //{


                    if (ii >= 128) {
                        bytess[kk] = (-128) + (ii % 128);

                        //Log.e("the value of i in lo", ii + " ");
                        Log.e("k", bytess[kk] + " ");
                        kk++;
                    } else {
                        bytess[kk] = ii;

                        //Log.e("the value of i in lo", ii + " ");
                        Log.e("k", bytess[kk] + " ");
                        kk++;
                    }

                    //Log.e("val of i", ii + " ");

                    countt++;
                //}

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("the val count the rec", countt + " ");
        /*Log.e("the val of k of the rec", kk + " ");
        Log.e("the val of k of the org",or.k+" ");
        */
        FFT ff = new FFT();
        //Log.e("asdasd", "ASdasd");
        ff.receive(bytess, kk, or.bytes, or.k);
        cancel(true);

        return null;
    }
}


class orgg extends AsyncTask<Integer, Void, Void> {

    static public int[] clr = new int[Integer.MAX_VALUE/10000];
    static public int[] bytes = new int[Integer.MAX_VALUE / 1000];
    static public int k = 0;
    protected Void doInBackground(Integer... params) {


        int count = 0;
        Integer pos = params[0];



        try {
            String ffname = "";
            if(pos==0) {
                ffname = "jannat.mp3";
            }
            if(pos==1) {
                ffname = "baby.mp3";
            }
            if(pos==2) {
                ffname = "samjhawan.mp3";
            }
            if(pos==3) {
                ffname = "tum mile.mp3";
            }
            if(pos==4) {
                ffname = "saibo.mp3";
            }
            if(pos==5) {
                ffname = "one dir.mp3";
            }
            if(pos==6) {
                ffname = "taylor.mp3";
            }
            if(pos==7) {
                ffname = "love me.mp3";
            }
            if(pos==8) {
                ffname = "bruno mars.mp3";
            }
            if(pos==9) {
                ffname = "emptiness.mp3";
            }
            //String fileName = "maysmjh.3gp";
            String path = "";
            path = Environment.getExternalStorageDirectory() + "/" + ffname;

            File file = new File(path);
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(file);

            int i = 0;

            int j = 0;
            int prvsi = 0;
            count = 0;
            while ((i = fileInputStream.read()) != -1) {

                //if (Math.abs(i - prvsi) >= 40) {


                //Log.e("before prvsi", prvsi + " ");
                if (i >= 128) {
                    bytes[k] = (-128) + (i % 128);

                    Log.e("the value of i in lo", i + " ");
                    Log.e("byte array value.... ", bytes[k] + " ");
                    k++;
                } else {
                    bytes[k] = i;

                    Log.e("the value of i in lo", i + " ");
                    Log.e("byte array value.... ", bytes[k] + " ");
                    k++;
                }
                //prvsi = i;
                Log.e("val of i", i + " ");
                //Log.e("after prvsi", prvsi + " ");
                //}
                /*else
                {
                    clr[j] = count;
                    j++;
                }*/
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("the val of count", count + " ");
        Log.e("the val of k", k + " ");



        return null;

    }

    protected  void onPostExecute(){
        Log.e("the post", "post execution");
    }
}




class BackgroundSound extends AsyncTask<Integer, Void, Void> {

    MediaPlayer player = new MediaPlayer();
    @Override

    protected Void doInBackground(Integer... params) {
        int pos  = params[0];

        //String fileName = "bg.mp3";
        String fileName = "";
        if(pos==0) {
            fileName = "jannat 1.mp3";
        }
        if(pos==1) {
            fileName = "baby1.mp3";
        }
        if(pos==2) {
            fileName = "samjhawan1.mp3";
        }
        if(pos==3) {
            fileName = "tum mile1.mp3";
        }
        if(pos==4) {
            fileName = "saibo1.mp3";
        }
        if(pos==5) {
            fileName = "one dir 1.mp3";
        }
        if(pos==6) {
            fileName = "taylor 1.mp3";
        }
        if(pos==7) {
            fileName = "love me 1.mp3";
        }
        if(pos==8) {
            fileName = "bruno mars 1.mp3";
        }
        if(pos==9) {
            fileName = "emptiness1.mp3";
        }
        String path = "";

        path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+fileName;
        //MediaPlayer player = new MediaPlayer();
        try {
            player.setDataSource(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setLooping(false); // Set looping
        player.setVolume(1000, 1000);
        player.prepareAsync();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {


            @Override

            public void onPrepared(MediaPlayer mp) {

                Log.e("Sdfdsf", "fsdf");

                mp.start();
                if(isCancelled())
                    mp.stop();


            }
        });



        return null;
    }
    /*public void cancelel()
    {
        mp.stop();
    }*/

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.e("post", "post");
        super.onPostExecute(aVoid);
    }
}


