# coding=utf-8
# *** WARNING: this file was generated by pulumigen. ***
# *** Do not edit by hand unless you're certain you know what you are doing! ***

import copy
import warnings
import pulumi
import pulumi.runtime
from typing import Any, Callable, Mapping, Optional, Sequence, Union, overload
from ... import _utilities

__all__ = [
    'ReleaseStatus',
    'RepositoryOpts',
]

@pulumi.output_type
class ReleaseStatus(dict):
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "appVersion":
            suggest = "app_version"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in ReleaseStatus. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        ReleaseStatus.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        ReleaseStatus.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 status: str,
                 app_version: Optional[str] = None,
                 chart: Optional[str] = None,
                 name: Optional[str] = None,
                 namespace: Optional[str] = None,
                 revision: Optional[int] = None,
                 version: Optional[str] = None):
        """
        :param str status: Status of the release.
        :param str app_version: The version number of the application being deployed.
        :param str chart: The name of the chart.
        :param str name: Name is the name of the release.
        :param str namespace: Namespace is the kubernetes namespace of the release.
        :param int revision: Version is an int32 which represents the version of the release.
        :param str version: A SemVer 2 conformant version string of the chart.
        """
        ReleaseStatus._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            status=status,
            app_version=app_version,
            chart=chart,
            name=name,
            namespace=namespace,
            revision=revision,
            version=version,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             status: Optional[str] = None,
             app_version: Optional[str] = None,
             chart: Optional[str] = None,
             name: Optional[str] = None,
             namespace: Optional[str] = None,
             revision: Optional[int] = None,
             version: Optional[str] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if status is None:
            raise TypeError("Missing 'status' argument")
        if app_version is None and 'appVersion' in kwargs:
            app_version = kwargs['appVersion']

        _setter("status", status)
        if app_version is not None:
            _setter("app_version", app_version)
        if chart is not None:
            _setter("chart", chart)
        if name is not None:
            _setter("name", name)
        if namespace is not None:
            _setter("namespace", namespace)
        if revision is not None:
            _setter("revision", revision)
        if version is not None:
            _setter("version", version)

    @property
    @pulumi.getter
    def status(self) -> str:
        """
        Status of the release.
        """
        return pulumi.get(self, "status")

    @property
    @pulumi.getter(name="appVersion")
    def app_version(self) -> Optional[str]:
        """
        The version number of the application being deployed.
        """
        return pulumi.get(self, "app_version")

    @property
    @pulumi.getter
    def chart(self) -> Optional[str]:
        """
        The name of the chart.
        """
        return pulumi.get(self, "chart")

    @property
    @pulumi.getter
    def name(self) -> Optional[str]:
        """
        Name is the name of the release.
        """
        return pulumi.get(self, "name")

    @property
    @pulumi.getter
    def namespace(self) -> Optional[str]:
        """
        Namespace is the kubernetes namespace of the release.
        """
        return pulumi.get(self, "namespace")

    @property
    @pulumi.getter
    def revision(self) -> Optional[int]:
        """
        Version is an int32 which represents the version of the release.
        """
        return pulumi.get(self, "revision")

    @property
    @pulumi.getter
    def version(self) -> Optional[str]:
        """
        A SemVer 2 conformant version string of the chart.
        """
        return pulumi.get(self, "version")


@pulumi.output_type
class RepositoryOpts(dict):
    """
    Specification defining the Helm chart repository to use.
    """
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "caFile":
            suggest = "ca_file"
        elif key == "certFile":
            suggest = "cert_file"
        elif key == "keyFile":
            suggest = "key_file"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in RepositoryOpts. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        RepositoryOpts.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        RepositoryOpts.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 ca_file: Optional[str] = None,
                 cert_file: Optional[str] = None,
                 key_file: Optional[str] = None,
                 password: Optional[str] = None,
                 repo: Optional[str] = None,
                 username: Optional[str] = None):
        """
        Specification defining the Helm chart repository to use.
        :param str ca_file: The Repository's CA File
        :param str cert_file: The repository's cert file
        :param str key_file: The repository's cert key file
        :param str password: Password for HTTP basic authentication
        :param str repo: Repository where to locate the requested chart. If is a URL the chart is installed without installing the repository.
        :param str username: Username for HTTP basic authentication
        """
        RepositoryOpts._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            ca_file=ca_file,
            cert_file=cert_file,
            key_file=key_file,
            password=password,
            repo=repo,
            username=username,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             ca_file: Optional[str] = None,
             cert_file: Optional[str] = None,
             key_file: Optional[str] = None,
             password: Optional[str] = None,
             repo: Optional[str] = None,
             username: Optional[str] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if ca_file is None and 'caFile' in kwargs:
            ca_file = kwargs['caFile']
        if cert_file is None and 'certFile' in kwargs:
            cert_file = kwargs['certFile']
        if key_file is None and 'keyFile' in kwargs:
            key_file = kwargs['keyFile']

        if ca_file is not None:
            _setter("ca_file", ca_file)
        if cert_file is not None:
            _setter("cert_file", cert_file)
        if key_file is not None:
            _setter("key_file", key_file)
        if password is not None:
            _setter("password", password)
        if repo is not None:
            _setter("repo", repo)
        if username is not None:
            _setter("username", username)

    @property
    @pulumi.getter(name="caFile")
    def ca_file(self) -> Optional[str]:
        """
        The Repository's CA File
        """
        return pulumi.get(self, "ca_file")

    @property
    @pulumi.getter(name="certFile")
    def cert_file(self) -> Optional[str]:
        """
        The repository's cert file
        """
        return pulumi.get(self, "cert_file")

    @property
    @pulumi.getter(name="keyFile")
    def key_file(self) -> Optional[str]:
        """
        The repository's cert key file
        """
        return pulumi.get(self, "key_file")

    @property
    @pulumi.getter
    def password(self) -> Optional[str]:
        """
        Password for HTTP basic authentication
        """
        return pulumi.get(self, "password")

    @property
    @pulumi.getter
    def repo(self) -> Optional[str]:
        """
        Repository where to locate the requested chart. If is a URL the chart is installed without installing the repository.
        """
        return pulumi.get(self, "repo")

    @property
    @pulumi.getter
    def username(self) -> Optional[str]:
        """
        Username for HTTP basic authentication
        """
        return pulumi.get(self, "username")


