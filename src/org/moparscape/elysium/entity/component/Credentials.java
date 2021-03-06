package org.moparscape.elysium.entity.component;

import org.moparscape.elysium.util.DataConversions;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by IntelliJ IDEA.
 *
 * @author lothy
 */
public final class Credentials extends AbstractComponent {

    private final AtomicReference<String> password = new AtomicReference<String>();

    /**
     * An atomically updatable reference used to ensure that changes
     * to the username and username hash are consistent and not prone
     * to threading issues such as races and pre-empting.
     */
    private final AtomicReference<UsernameHashPair> usernameAndHash =
            new AtomicReference<UsernameHashPair>();

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.getAndSet(password);
    }

    public String getUsername() {
        return usernameAndHash.get().username;
    }

    public void setUsername(String username) {
        this.usernameAndHash.getAndSet(new UsernameHashPair(username));
    }

    public long getUsernameHash() {
        return usernameAndHash.get().hash;
    }

    @Override
    public int hashCode() {
        return (usernameAndHash.get().username.hashCode() * 31) |
                (password.hashCode() * 31);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || !(o instanceof Credentials)) {
            return false;
        }

        Credentials c = (Credentials) o;
        return usernameAndHash.get().username.equals(c.usernameAndHash.get().username) &&
                password.equals(c.password);
    }

    @Override
    public String toString() {
        return getUsername() + " " + getPassword();
    }

    private static final class UsernameHashPair {

        private final long hash;
        private final String username;

        public UsernameHashPair(String username) {
            this.username = username;
            this.hash = DataConversions.usernameToHash(username);
        }
    }
}
