package com.dhb.qqhook.activities;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Toast;

import com.dhb.qqhook.Common;
import com.dhb.qqhook.R;

public class AboutActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.about_preference);

        Preference versionPreference = findPreference("version");
        versionPreference.setSummary(getVersionName());

        Preference suggestionPreference = findPreference("suggestion");
        suggestionPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                openWeb("http://weibo.com/u/2483019873");
                return true;
            }
        });

        Preference zfbPreference = findPreference("zfb");
        zfbPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Common.copy("13169777377", AboutActivity.this);
                return true;
            }
        });

        Preference lookWifiAppPreference = findPreference("app_wifi");
        lookWifiAppPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                openWeb("http://bbs.zhiyoo.com/thread-9635940-1-1.html");
                return true;
            }
        });

        Preference speedAppPreference = findPreference("app_speed");
        speedAppPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                openWeb("http://bbs.zhiyoo.com/thread-9676517-1-1.html");
                return true;
            }
        });

        Preference xposedPreference = findPreference("xposed");
        xposedPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                openWeb("https://github.com/rovo89/XposedInstaller");
                return true;
            }
        });
    }

    private String getVersionName() {
        PackageManager manager;
        PackageInfo info;
        manager = this.getPackageManager();
        String VersionName = "null";
        try {
            info = manager.getPackageInfo(this.getPackageName(), 0);
            VersionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return VersionName;
    }

    private void openWeb(String s) {
        Uri uri = Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
