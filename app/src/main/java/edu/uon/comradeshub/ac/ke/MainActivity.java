package edu.uon.comradeshub.ac.ke;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    // Array of items with name and corresponding URL
    private final String[] cardItems = {
            "HELB-https://portal.hef.co.ke/auth/signin",
            "Health Services-https://healthservices.uonbi.ac.ke/",
            "Smis Portal-https://smis.uonbi.ac.ke/",
            "Active Directory-http://adstudents.uonbi.ac.ke/",
            "Mtihani Platform-https://mtihani.uonbi.ac.ke",
            "UoN Library-https://uonlibrary.uonbi.ac.ke/",
            "UON Research-https://uonresearch.uonbi.ac.ke/",
            "IPMO-https://ipmo.uonbi.ac.ke/",
            "Academics-https://academics.uonbi.ac.ke/",
            "Baad Tutor"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Set GridLayoutManager with 2 columns
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Set Adapter
        CardAdapter adapter = new CardAdapter(cardItems);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contacts, menu);
        getMenuInflater().inflate(R.menu.share_app, menu);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.shareButton) {
          //  Uri uri = Uri.parse("market://details?id=" + getPackageName());
           // Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
           intent.putExtra("android.intent.extra.SUBJECT", "Check out this cool UON application ");
           intent.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=" + getPackageName());
            startActivity(Intent.createChooser(intent, "Share via"));
            return super.onOptionsItemSelected(item);
//NOT USING SWITCH BECAUSE THE VALUES ARE NOT  HENCE ELSE IF
        }
        else if (id == R.id.arts_mail) {
            sendEmail("deanfass@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_arts_ict_email) {
            sendEmail("ictsupportfoa@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_arts_ict_help_email) {
            sendEmail("foahelp@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_execdean_fbe_email) {
            sendEmail("execdean-fbe@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_ictsupport_add_email) {
            sendEmail("ictsupportadd@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_sbe_help_email) {
            sendEmail("sbehelp@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_dean_fed_email) {
            sendEmail("dean-fed@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_ictsupport_cees_email) {
            sendEmail("ictsupportcees@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_soed_help_email) {
            sendEmail("soedhelp@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_dean_fhs_email) {
            sendEmail("dean-fhs@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_medicine_ictsupport_email) {
            sendEmail("ictsupportchs@uonbi.ac.ke");
            return true;
        }

        else if (id == R.id.menu_medicine_help_email) {
            sendEmail("medicinehelp@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_nursing_help_email) {
            sendEmail("nursinghelp@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_pharmacy_help_email) {
            sendEmail("pharmacyhelp@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_dental_help_email) {
            sendEmail("dentalhelp@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_dean_fst_email) {
            sendEmail("dean-fst@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_sbs_help_email) {
            sendEmail("sbshelp@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_dean_law_email) {
            sendEmail("dean-law@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_ictsupport_sol_email) {
            sendEmail("ictsupportsol@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_sol_help_email) {
            sendEmail("solhelp@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_admissions_email) {
            sendEmail("admissions@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_examinations_email) {
            sendEmail("examinations@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_student_records_email) {
            sendEmail("student-records@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_pg_email) {
            sendEmail("pg@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_reg_dean_senate_email) {
            sendEmail("reg-deansenate@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_dvca_email) {
            sendEmail("dvca@uonbi.ac.ke");
            return true;
        } else if (id == R.id.menu_reg_academic_email) {
            sendEmail("reg-academic@uonbi.ac.ke");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    // Helper method to open email client
    private void sendEmail(String emailAddress) {
        // Create an intent to send an email
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

        // Ensure the URI is correctly formed with the "mailto:" scheme
        emailIntent.setData(Uri.parse("mailto:" + emailAddress));

        // Optional: Add extra data for subject and body (you can modify or remove these)
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body text here...");

        // Check if there is any email client installed that can handle the intent
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            // If an email client is available, start the activity
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        } else {
            // If no email client is available, show a message and optionally suggest installing one
            Toast.makeText(this, "No email client available. Please install an email client like Gmail.", Toast.LENGTH_LONG).show();

            // Optionally, you can redirect the user to the Play Store to install an email app like Gmail
            Intent marketIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.gm"));
            startActivity(marketIntent);
        }
    }


}
