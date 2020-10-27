package oc.p._8._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.ownership;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserPrincipal;

/**
 * public static UserPrincipal getOwner(Path path, LinkOption... options) throws IOException
 *
 * public static Path setOwner(Path path, UserPrincipal owner) throws IOException
 */

class Ownerhip {

    Path p = ResourcesOld.Create.Populate.SrcMainResources.file(this.getClass().getPackage(), "owner");

    void m() throws IOException {
        UserPrincipal up = Files.getOwner(p);
        System.out.println(up);

        UserPrincipal up2 = p.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName(ResourcesOld.USER);
        p = Files.setOwner(p, up2);

        up2 = Files.getOwner(p);
        System.out.println(up2);
    }

    public static void main(String[] args) throws IOException {
        Ownerhip o = new Ownerhip();

        o.m();
    }
}
