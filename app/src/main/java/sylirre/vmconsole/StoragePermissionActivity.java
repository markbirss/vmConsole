/*
*************************************************************************
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*************************************************************************
*/
package sylirre.vmconsole;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

/**
 * Ensure that application has storage access.
 * If running on Android 11+, we need to use MANAGE_EXTERNAL_STORAGE because application needs
 * manage file system on raw file path level bypassing Storage Access Framework.
 */
public class StoragePermissionActivity extends Activity {

    private final int WRITE_EXTERNAL_STORAGE_PERMISSION_CODE = 21;
    private final int MANAGE_EXTERNAL_STORAGE_PERMISSION_CODE = 42;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, MANAGE_EXTERNAL_STORAGE_PERMISSION_CODE);
        } else {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        verifyPermissions(requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        verifyPermissions(requestCode);
    }

    private void verifyPermissions(int requestCode) {
        boolean storagePermissionGranted = false;
        switch (requestCode) {
            case MANAGE_EXTERNAL_STORAGE_PERMISSION_CODE:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (Environment.isExternalStorageManager()) {
                        storagePermissionGranted = true;
                    }
                }
                break;
            case WRITE_EXTERNAL_STORAGE_PERMISSION_CODE:
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                    storagePermissionGranted = true;
                }
                break;
            default:
                Log.e(Config.APP_LOG_TAG, "got unknown permission request code: "
                    + requestCode);
                break;
        }

        if (storagePermissionGranted) {
            startActivity(new Intent(this, TerminalActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            Toast.makeText(this, R.string.toast_no_storage_permission, Toast.LENGTH_LONG).show();
        }
        finish();
    }
}
